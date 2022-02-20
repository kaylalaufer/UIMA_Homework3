package com.example.uima_homework3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
//import android.widget.ImageButton;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Random;

public class LearnMode extends AppCompatActivity {
    private static final Random rand = new Random();
    boolean switchHr;
    Time startTime;
    Time endTime;
    private int buttonChoice;
    private int[] differHr;
    ImageButton invisibleSmall;
    ImageButton invisibleMedium;
    ImageButton invisibleLarge;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("debug", "start");
        super.onCreate(savedInstanceState);
        Log.d("debug", "set state");
        setContentView(R.layout.activity_learn_mode);
        Log.d("debug", "set layout");

        startTime = new Time("2:17pm");
        endTime = new Time("2:17am");

        invisibleSmall = findViewById(R.id.imageButton8);
        invisibleMedium = findViewById(R.id.imageButton9);
        invisibleLarge = findViewById(R.id.imageButton10);
        sharedPreferences = getSharedPreferences("TimeMode", MODE_PRIVATE);
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
        int res = correctResult();
        sharedPreferences = getSharedPreferences("ButtonAns", MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.putInt("correctResult", res);
        editor.apply();

        sharedPreferences = getSharedPreferences("TimeDiffer", MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.putInt("correctHr", differHr[0]);
        editor.putInt("correctMin", differHr[1]);
        editor.apply();
    }


    public void onSmallButtonClicked(View view) {
        buttonChoice = 1;
        sharedPreferences = getSharedPreferences("ButtonAns", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("buttonChoice", buttonChoice);
        editor.apply();
        invisibleSmall.setVisibility(View.VISIBLE);
        invisibleMedium.setVisibility(View.INVISIBLE);
        invisibleLarge.setVisibility(View.INVISIBLE);
    }

    public void onMediumButtonClicked(View view) {
        buttonChoice = 2;
        sharedPreferences = getSharedPreferences("ButtonAns", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("buttonChoice", buttonChoice);
        editor.apply();
        invisibleMedium.setVisibility(View.VISIBLE);
        invisibleSmall.setVisibility(View.INVISIBLE);
        invisibleLarge.setVisibility(View.INVISIBLE);
    }

    public void onLargeButtonClicked(View view) {
        buttonChoice = 3;
        sharedPreferences = getSharedPreferences("ButtonAns", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("buttonChoice", buttonChoice);
        editor.apply();
        invisibleLarge.setVisibility(View.VISIBLE);
        invisibleSmall.setVisibility(View.INVISIBLE);
        invisibleMedium.setVisibility(View.INVISIBLE);
    }

    public void onCheckButtonClicked(View view) {
        Intent intent = new Intent(this, EasyResult.class);
        startActivity(intent);
        invisibleSmall.setVisibility(View.INVISIBLE);
        invisibleMedium.setVisibility(View.INVISIBLE);
        invisibleLarge.setVisibility(View.INVISIBLE);
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