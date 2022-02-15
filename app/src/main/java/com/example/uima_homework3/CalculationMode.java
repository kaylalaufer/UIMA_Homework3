package com.example.uima_homework3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CalculationMode extends AppCompatActivity {

    private EditText start1, start2, end1, end2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculation_mode);

        start1 = findViewById(R.id.editTextTime);
        start2 = findViewById(R.id.editTextTime5);
        end1 = findViewById(R.id.editTextTime6);
        end2 = findViewById(R.id.editTextTime7);
    }

    public void calculation(View view) {
        int startHour = Integer.parseInt(start1.getText().toString());
        int startMinute = Integer.parseInt(start2.getText().toString());
        int endHour = Integer.parseInt(end1.getText().toString());
        int endMinute = Integer.parseInt(end2.getText().toString());
        if (startHour > 23 || startHour < 0 || endHour > 23 || endHour < 0
            || startMinute > 59 || startMinute < 0 || endMinute > 59 || endMinute < 0) {
            Toast.makeText(this,"Invalid Input!", Toast.LENGTH_SHORT).show();
            invalidInput(startHour, startMinute, endHour, endMinute);
        } else {
            //Calculate difference between two military times
            int[] diff;
            diff = calculateDiff(startHour, startMinute, endHour, endMinute);
            TextView hour = findViewById(R.id.textView9);
            hour.setText(String.valueOf(diff[0]));
            TextView minute = findViewById(R.id.textView12);
            minute.setText(String.valueOf(diff[1]));
        }
    }

    private void invalidInput(int startHour, int startMinute, int endHour, int endMinute) {
        if (startHour > 23 || startHour < 0) {
            start1.setText("00");
        }
        if (endHour > 23 || endHour < 0) {
            end1.setText("00");
        }
        if (startMinute > 59 || startMinute < 0) {
            start2.setText("00");
        }
        if (endMinute > 59 || endMinute < 0) {
            end2.setText("00");
        }
    }

    //Calculate difference between two military times
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

