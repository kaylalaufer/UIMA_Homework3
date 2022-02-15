package com.example.uima_homework3;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        @SuppressLint("UseSwitchCompatOrMaterialCode") Switch switch1 = findViewById(R.id.switch1);
        switch1.setOnCheckedChangeListener((compoundButton, isChecked) -> {
            if (isChecked) {
                //Military Format
                Toast.makeText(getBaseContext(),"Military Format!", Toast.LENGTH_SHORT).show();
            } else {
                //Standard Format
                Toast.makeText(getBaseContext(),"Standard Format!", Toast.LENGTH_SHORT).show();
            }
        });
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