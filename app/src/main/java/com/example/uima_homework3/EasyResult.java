package com.example.uima_homework3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class EasyResult extends AppCompatActivity {

    ImageView smallWrong;
    ImageView mediumWrong;
    ImageView largeWrong;


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
    }
}