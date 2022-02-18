package com.example.uima_homework3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class EasyResult extends AppCompatActivity {

    ImageView smallWrong;
    ImageView mediumWrong;
    ImageView largeWrong;

    ImageView smallCheck;
    ImageView mediumCheck;
    ImageView largeCheck;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy_result);

        SharedPreferences sharedPreferences = getSharedPreferences("RandomTime", MODE_PRIVATE);
        TextView textView1 = findViewById(R.id.textView22);
        String startTime = sharedPreferences.getString("startTime", "");
        textView1.setText(startTime);
        TextView textView2 = findViewById(R.id.textView23);
        String endTime = sharedPreferences.getString("endTime", "");
        textView2.setText(endTime);

        smallWrong = findViewById(R.id.imageView6);
        mediumWrong = findViewById(R.id.imageView4);
        largeWrong = findViewById(R.id.imageView5);

        smallCheck = findViewById(R.id.imageView3);
        mediumCheck = findViewById(R.id.imageView8);
        largeCheck = findViewById(R.id.imageView7);

        sharedPreferences = getSharedPreferences("ButtonAns", MODE_PRIVATE);
        int buttonChoice = sharedPreferences.getInt("buttonChoice", 0);
        int correctAns = sharedPreferences.getInt("correctResult", -1);
        if (buttonChoice == correctAns) {
            //User choose the correct answer
            if (buttonChoice == 1) {
                smallCheck.setVisibility(View.VISIBLE);
                mediumCheck.setVisibility(View.INVISIBLE);
                largeCheck.setVisibility(View.INVISIBLE);
            } else if (buttonChoice == 2) {
                smallCheck.setVisibility(View.INVISIBLE);
                mediumCheck.setVisibility(View.VISIBLE);
                largeCheck.setVisibility(View.INVISIBLE);
            } else {
                smallCheck.setVisibility(View.INVISIBLE);
                mediumCheck.setVisibility(View.INVISIBLE);
                largeCheck.setVisibility(View.VISIBLE);
            }
        } else {
            if (buttonChoice == 1) {
                smallWrong.setVisibility(View.VISIBLE);
                mediumWrong.setVisibility(View.INVISIBLE);
                largeWrong.setVisibility(View.INVISIBLE);
            } else if (buttonChoice == 2) {
                smallWrong.setVisibility(View.INVISIBLE);
                mediumWrong.setVisibility(View.VISIBLE);
                largeWrong.setVisibility(View.INVISIBLE);
            } else {
                smallWrong.setVisibility(View.INVISIBLE);
                mediumWrong.setVisibility(View.INVISIBLE);
                largeWrong.setVisibility(View.VISIBLE);
            }
        }
    }

    public void onRetryButtonClicked(View view) {
        this.finish();
    }

    public void onNextButtonClicked(View view) {
        Intent intent = new Intent(this, LearnHard.class);
        startActivity(intent);
    }
}