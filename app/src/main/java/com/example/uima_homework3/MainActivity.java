package com.example.uima_homework3;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.Toast;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public static final String sw = "switch";
    public SharedPreferences sharedPreferences;
    private Switch switch1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // @SuppressLint("UseSwitchCompatOrMaterialCode")
        switch1 = findViewById(R.id.switch1);
        sharedPreferences = getSharedPreferences("", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        switch1.setChecked(sharedPreferences.getBoolean(sw, false));
        switch1.setOnCheckedChangeListener((compoundButton, isChecked) -> {
            if (isChecked) {
                //Military Format
                editor.putBoolean(sw, true);
                Toast.makeText(getBaseContext(),"Military Format!", Toast.LENGTH_SHORT).show();
            } else {
                //Standard Format
                editor.putBoolean(sw, false);
                Toast.makeText(getBaseContext(),"Standard Format!", Toast.LENGTH_SHORT).show();
            }
            editor.commit();
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
