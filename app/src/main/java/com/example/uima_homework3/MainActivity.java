package com.example.uima_homework3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Switch switch1 = findViewById(R.id.switch1);
    }

    public void onCalculationButtonClicked(View view) {
        Intent intent = new Intent(this, CalculationMode.class);
        startActivity(intent);
    }

    public void onLearnButtonClicked(View view) {
        Intent intent = new Intent(this, LearnMode.class);
        startActivity(intent);
    }
}