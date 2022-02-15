package com.example.uima_homework3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CalculationMode extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculation_mode);

        // Get the Intent that started this activity
        Intent intent = getIntent();
    }

    public void calculateDiff(View view) {
        Intent intent = new Intent(this, CalculationMode.class);
        EditText start1 = findViewById(R.id.editTextTime);
        int startHour = Integer.parseInt(start1.getText().toString());
        EditText start2 = findViewById(R.id.editTextTime5);
        int startMinute = Integer.parseInt(start2.getText().toString());
        EditText start3 = findViewById(R.id.editTextTime6);
        int endHour = Integer.parseInt(start3.getText().toString());
        EditText start4 = findViewById(R.id.editTextTime7);
        int endMinute = Integer.parseInt(start4.getText().toString());
        if (startHour > 23 || startHour < 0 || endHour > 23 || endHour < 0) {
            Toast.makeText(getBaseContext(),"Invalid Input Hour!", Toast.LENGTH_LONG).show();
        } else if (startMinute > 59 || startMinute < 0 || endMinute > 59 || endMinute < 0) {
            Toast.makeText(getBaseContext(),"Invalid Input Minute!", Toast.LENGTH_LONG).show();
        }


    }
}

