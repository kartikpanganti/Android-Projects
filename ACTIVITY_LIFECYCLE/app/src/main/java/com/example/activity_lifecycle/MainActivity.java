package com.example.activity_lifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this,"Activity created",Toast.LENGTH_SHORT).show();
    }

    public void onStart()
    {
        super.onStart();
        Toast.makeText(this,"Activity started",Toast.LENGTH_SHORT).show();
    }

    public void onResume()
    {
        super.onResume();
        Toast.makeText(this,"Activity Resumed",Toast.LENGTH_SHORT).show();
    }

    public void onPause()
    {
        super.onPause();
        Toast.makeText(this,"Activity Paused",Toast.LENGTH_SHORT).show();
    }

    public void onRestart()
    {
        super.onRestart();
        Toast.makeText(this,"Activity Restart",Toast.LENGTH_SHORT).show();
    }

    public void onDestroy()
    {
        super.onDestroy();
        Toast.makeText(this,"Activity Destroyed",Toast.LENGTH_SHORT).show();
    }
}