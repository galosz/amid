package com.example.async_02;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button buttonAddNew = findViewById(R.id.buttonAddNew);
        listView = findViewById(R.id.listViewItems);

        Button buttonShowAll = findViewById(R.id.buttonShowAll);
        buttonShowAll.setOnClickListener(v -> {
            new LoadDataAsyncTask(this, listView).execute();
        });

        buttonAddNew.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, activity_add_edit_item.class);
            startActivity(intent);
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        new LoadDataAsyncTask(this, listView).execute();
    }
}

