package com.example.uima_homework3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class LearnMode extends AppCompatActivity {
    int randNum;
    private static final Random rand = new Random();
    boolean switchHr;
    Time startTime;
    Time endTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_mode);

        // Get the Intent that started this activity
        Intent intent = getIntent();
        startTime = new Time("2:17pm");
        endTime = new Time("2:17am");
        SharedPreferences sharedPreferences = getSharedPreferences("TimeMode", MODE_PRIVATE);
        switchHr = sharedPreferences.getBoolean(MainActivity.sw, true);
        //if true - military format

        TextView textView1 = findViewById(R.id.textView10);
        int rand1 = rand.nextInt(23);
        startTime.setHours(rand1);
        //textView1.setText(numberString(rand1));

        TextView textView2 = findViewById(R.id.textView16);
        int rand2 = rand.nextInt(59);
        startTime.setMins(rand2);

        //TextView textView3 = findViewById(R.id.textView15);
        int rand3 = rand.nextInt(23);
        endTime.setHours(rand3);

        //TextView textView4 = findViewById(R.id.textView17);
        int rand4 = rand.nextInt(59);
        endTime.setMins(rand4);
       //textView4.setText(numberString(rand4));

        if (switchHr) { //military time
            textView1.setText(startTime.military());
            textView2.setText(endTime.military());
        } else {
            textView1.setText(startTime.toString());
            textView2.setText(endTime.toString());
        }

    }
}