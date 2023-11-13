package com.example.bouncing_ball;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TargetView targetView = new TargetView(this);

        setContentView(targetView);
    }
}