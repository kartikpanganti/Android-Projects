package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText height, weight, result ,tip;
        Button b;
        height = findViewById(R.id.height);
        weight = findViewById(R.id.weight);
        result = findViewById(R.id.editTextText);
        tip = findViewById(R.id.editTextText2);
        b = findViewById(R.id.button);


        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String first=height.getText().toString();
                String second=weight.getText().toString();
                float heightInMeters = (float) (Float.parseFloat(first) * 0.3048);
                float a = Float.parseFloat(second) / (heightInMeters * heightInMeters);

                float res=a;
                if (res <18.5) {
                    result.setText(Float.toString(res));
                    tip.setText("UNDER WEIGHT");
                }
                else if (res >= 18.5 && res < 24.9) {
                    result.setText(Float.toString(res));
                    tip.setText("NORMAL WEIGHT");
                }
                else if (res >= 25.0 && res < 29.9) {
                    result.setText(Float.toString(res));
                    tip.setText("OVER WEIGHT");
                }
                else if (res >= 30.0 && res < 34.9) {
                    result.setText(Float.toString(res));
                    tip.setText("OBESE 1 WEIGHT");
                }
                else if (res >= 35.0 && res < 39.9) {
                    result.setText(Float.toString(res));
                    tip.setText(" OBESE 2 WEIGHT");
                }
                else {
                    result.setText(Float.toString(res));
                    tip.setText("OBESE 3 WEIGHT");
                }

            }
        });

    }
}