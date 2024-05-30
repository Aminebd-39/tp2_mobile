package com.enset.tp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonAdd = findViewById(R.id.buttonAdd);
        EditText input1 = findViewById(R.id.edit1);
        EditText input2 = findViewById(R.id.edit2);
        ListView listView = findViewById(R.id.listview);
        List<String> listData = new ArrayList<>();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listData);

        listView.setAdapter(adapter);

        buttonAdd.setOnClickListener(v -> {
            String name = input1.getText().toString().trim();
            String email = input2.getText().toString().trim();
            if (!name.isEmpty() && !email.isEmpty()) {
                String entry = "Name: " + name + "\nEmail: " + email;
                listData.add(entry);
                adapter.notifyDataSetChanged();

                input1.getText().clear();
                input2.getText().clear();
            } else {
                Toast.makeText(MainActivity.this, "Please enter both name and email.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}