package com.example.uima_homework3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String sw = "switch";
    public SharedPreferences sharedPreferences;
    private Switch switch1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //@SuppressLint("UseSwitchCompatOrMaterialCode") Switch
        switch1 = findViewById(R.id.switch1);
        sharedPreferences = getSharedPreferences("TimeMode", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        switch1.setChecked(sharedPreferences.getBoolean(sw, true));
        switch1.setOnCheckedChangeListener((compoundButton, isChecked) -> {
            if (isChecked) {
                //Military Format
                Toast.makeText(getBaseContext(),"Military Format!", Toast.LENGTH_SHORT).show();
            } else {
                //Standard Format
                Toast.makeText(getBaseContext(),"Standard Format!", Toast.LENGTH_SHORT).show();
            }
            editor.putBoolean(sw, switch1.isChecked());
            editor.apply();
        });
    }

    public void onCalculationButtonClicked(View view) {
        Intent intent = new Intent(this, CalculationMode.class);
        startActivity(intent);
    }

    public void onLearnButtonClicked(View view) {
        Log.d("debug", "clicked");
        Intent intent = new Intent(this, LearnMode.class);
        Log.d("debug", "intent");
        startActivity(intent);
        Log.d("debug", "start act");
    }

}
