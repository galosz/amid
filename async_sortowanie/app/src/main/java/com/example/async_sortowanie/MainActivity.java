package com.example.async_sortowanie;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    private EditText inputSize;
    private Button startButton;
    private ProgressBar progressBar;
    private SortingView sortingView;

    private ExecutorService executorService;
    private Handler uiHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeViews();
        setupHandlers();

        startButton.setOnClickListener(v -> handleStartButtonClick());
    }

    private void initializeViews() {
        inputSize = findViewById(R.id.inputSize);
        startButton = findViewById(R.id.startButton);
        progressBar = findViewById(R.id.progressBar);
        sortingView = findViewById(R.id.sortingView);
    }

    private void setupHandlers() {
        executorService = Executors.newSingleThreadExecutor();
        uiHandler = new Handler(Looper.getMainLooper());
    }

    private void handleStartButtonClick() {
        String input = inputSize.getText().toString().trim();
        if (input.isEmpty()) {
            showToast("Nie podałeś ilosci elementow");
            return;
        }

        try {
            int size = Integer.parseInt(input);
            if (size <= 0) {
                showToast("Liczba nie może być ujemna");
            } else {
                startSorting(size);
            }
        } catch (NumberFormatException e) {
            showToast("Podaj poprawną liczbę");
        }
    }

    private void startSorting(int size) {
        int[] array = generateArray(size);

        progressBar.setProgress(0);
        sortingView.setArray(array);

        executorService.execute(() -> {
            performBubbleSort(array);
            uiHandler.post(() -> {
                showToast("Sortowanie zakończone!");
                progressBar.setProgress(100);
                sortingView.setArray(array);
            });
        });
    }

    private int[] generateArray(int size) {
        Random random = new Random();
        return random.ints(size, 1, 501).toArray();
    }

    private void performBubbleSort(int[] array) {
        int size = array.length;
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
            updateProgress(array, i, size);
        }
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private void updateProgress(int[] array, int currentIndex, int size) {
        int progress = (int) (((currentIndex + 1) / (float) size) * 100);
        uiHandler.post(() -> {
            progressBar.setProgress(progress);
            sortingView.setArray(Arrays.copyOf(array, array.length));
        });

        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
