package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView i11=(ImageView) findViewById(R.id.p11);

        i11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i11.setImageResource(Integer.parseInt("@drawable/o.png"));
            }
        });
    }
}