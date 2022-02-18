package com.example.uima_homework3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

        hours = findViewById(R.id.seekBar);
        minutes = findViewById(R.id.seekBar3);

        TextView inputHr = findViewById(R.id.textView34);
        TextView inputMin = findViewById(R.id.textView35);

        inputHr.setText(String.valueOf(hours.getProgress()));
        inputMin.setText(String.valueOf(minutes.getProgress()));
/*
        hours.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int pval = 0;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                pval = progress;
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                inputHr.setText(String.valueOf(pval));
            }
        });
*/

    }

    public void onCheck(View view) {
        //String strHr = "" + userHr;
        //String strMin = "" + userMin;
        //inputHr.setText(strHr);
        //inputMin.setText(strMin);
        //inputHr.setVisibility(View.VISIBLE);
        //inputMin.setVisibility(View.VISIBLE);
        int userHr = hours.getProgress();
        int userMin = minutes.getProgress();
        if (userHr == correctHr && userMin == correctMin) {
            check.setVisibility(View.INVISIBLE);
            correct.setVisibility(View.VISIBLE);
        } else {
            check.setVisibility(View.INVISIBLE);
            incorrect.setVisibility(View.VISIBLE);
        }
    }
}