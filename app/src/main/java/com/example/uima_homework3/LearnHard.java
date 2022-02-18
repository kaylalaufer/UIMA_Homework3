package com.example.uima_homework3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class LearnHard extends AppCompatActivity {

    //private EditText hour, minutes;
    private int correctHr, correctMin;
    private SeekBar hours;
    private SeekBar minutes;
    private TextView correct;
    private TextView incorrect;
    private Button check;
    private Button retry;
    private Button home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_hard);

        SharedPreferences sharedPreferences = getSharedPreferences("RandomTime", MODE_PRIVATE);
        TextView textView1 = findViewById(R.id.textView24);
        String startTime = sharedPreferences.getString("startTime", "");
        textView1.setText(startTime);
        TextView textView2 = findViewById(R.id.textView25);
        String endTime = sharedPreferences.getString("endTime", "");
        textView2.setText(endTime);

        sharedPreferences = getSharedPreferences("TimeDiffer", MODE_PRIVATE);
        correctHr = sharedPreferences.getInt("correctHr", -1);
        correctMin = sharedPreferences.getInt("correctMin", -1);

        correct = findViewById(R.id.textView36);
        incorrect = findViewById(R.id.textView37);
        check = findViewById(R.id.button4);
        retry = findViewById(R.id.button5);
        home = findViewById(R.id.button8);

        hours = findViewById(R.id.seekBar);
        minutes = findViewById(R.id.seekBar3);

        TextView inputHr = findViewById(R.id.textView34);
        TextView inputMin = findViewById(R.id.textView35);

        inputHr.setText(String.valueOf(hours.getProgress()));
        inputMin.setText(String.valueOf(minutes.getProgress()));

        hours.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int val = 0;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                val = progress;
                inputHr.setText(String.valueOf(val));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        minutes.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int val = 0;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                val = progress;
                inputMin.setText(String.valueOf(val));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }

    public void onCheck(View view) {
        int userHr = hours.getProgress();
        int userMin = minutes.getProgress();
        retry.setVisibility(View.VISIBLE);
        home.setVisibility(View.VISIBLE);
        if (userHr == correctHr && userMin == correctMin) {
            check.setVisibility(View.INVISIBLE);
            correct.setVisibility(View.VISIBLE);
        } else {
            check.setVisibility(View.INVISIBLE);
            incorrect.setVisibility(View.VISIBLE);
        }
    }

    public void onRetry (View view) {
        check.setVisibility(View.VISIBLE);
        incorrect.setVisibility(View.INVISIBLE);
        correct.setVisibility(View.INVISIBLE);
        retry.setVisibility(View.INVISIBLE);
        home.setVisibility(View.INVISIBLE);
    }

    public void onHome(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}