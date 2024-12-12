package com.example.okno;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class TaskDetailActivity extends AppCompatActivity {
    private EditText inputTaskName, inputTaskDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_detail);

        inputTaskName = findViewById(R.id.editTextTaskDetailName);
        inputTaskDescription = findViewById(R.id.editTextTaskDetailDescription);
        Button btnSaveChanges = findViewById(R.id.buttonUpdateTask);

        Intent incomingIntent = getIntent();
        int taskIndex = incomingIntent.getIntExtra("pozycja", -1);
        String taskTitle = incomingIntent.getStringExtra("nazwa");
        String taskDetails = incomingIntent.getStringExtra("opis");

        inputTaskName.setText(taskTitle);
        inputTaskDescription.setText(taskDetails);

        btnSaveChanges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String updatedTitle = inputTaskName.getText().toString();
                String updatedDetails = inputTaskDescription.getText().toString();

                Intent resultIntent = new Intent();
                resultIntent.putExtra("pozycja", taskIndex);
                resultIntent.putExtra("nazwa", updatedTitle);
                resultIntent.putExtra("opis", updatedDetails);
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
    }
}
