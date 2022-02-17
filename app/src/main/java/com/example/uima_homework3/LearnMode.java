package com.example.uima_homework3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class LearnMode extends AppCompatActivity {
    int randNum;
    private static final Random rand = new Random();
    boolean switchHr;
    Time startTime;
    Time endTime;
    private int buttonChoice;
    private int[] differHr;

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


        sharedPreferences = getSharedPreferences("RandomTime", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        if (switchHr) { //military time
            editor.putString("startTime", startTime.military());
            editor.putString("endTime", endTime.military());
            editor.apply();
            textView1.setText(startTime.military());
            textView2.setText(endTime.military());
        } else {
            editor.putString("startTime", startTime.toString());
            editor.putString("endTime", endTime.toString());
            editor.apply();
            textView1.setText(startTime.toString());
            textView2.setText(endTime.toString());
        }
        differHr = calculateDiff(startTime.getHour(), startTime.getMins(), endTime.getHour(), endTime.getMins());
    }

    public void onSmallButtonClicked(View view) {
        buttonChoice = 1;
    }

    public void onMediumButtonClicked(View view) {
        buttonChoice = 2;
    }

    public void onLargeButtonClicked(View view) {
        buttonChoice = 3;
    }

    public void onCheckButtonClicked(View view) {
        Intent intent = new Intent(this, EasyResult.class);
        startActivity(intent);
    }

    private int correctResult () {
        if (differHr[0] < 8) {
            return 1;
        } else if (differHr[0] > 16 || (differHr[0] == 16 && differHr[1] != 0)) {
            return 3;
        }
        return 2;
    }

    private int[] calculateDiff(int startHour, int startMinute, int endHour, int endMinute) {
        int diffHour;
        int diffMinute;
        if (endHour >= startHour) {
            if (endMinute >= startMinute) {
                diffHour = endHour - startHour;
                diffMinute = endMinute - startMinute;
            } else if (endHour > startHour) {
                diffMinute = endMinute + 60 - startMinute;
                diffHour = endHour - 1 - startHour;
            } else {
                int[] day1 = calculateDiff(startHour, startMinute, 24, 0);
                diffMinute = day1[1] + endMinute;
                diffHour = day1[0] + endHour;
                if (diffMinute >= 60) {
                    diffMinute -=60;
                    diffHour += 1;
                }
            }
        } else {
            int[] day1 = calculateDiff(startHour, startMinute, 24, 0);
            diffMinute = day1[1] + endMinute;
            diffHour = day1[0] + endHour;
            if (diffMinute >= 60) {
                diffMinute -=60;
                diffHour += 1;
            }
        }
        return new int[]{diffHour, diffMinute};
    }

}