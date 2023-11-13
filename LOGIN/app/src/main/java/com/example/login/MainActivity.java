package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.annotation.GlideExtension;

import java.time.Instant;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        ANIMATION==================================
        setContentView(R.layout.activity_main);
        ImageView ifg = findViewById(R.id.imageView2);
        ImageView ig = findViewById(R.id.imageView5);
        Glide.with(this)
                .load(R.drawable.pika)
                .into(ifg);
        Glide.with(this)
                .load(R.drawable.text)
                .into(ig);
//==================================================================
        EditText e =findViewById(R.id.editTextTextEmailAddress);
        EditText e2 =findViewById(R.id.editTextTextPassword);
        Button b =findViewById(R.id.button);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(e.getText().toString().equals("administrator") && e2.getText().toString().equals("password")){

                    Toast.makeText(getApplicationContext(),"correct",Toast.LENGTH_SHORT).show();

                }
                else {
                    Toast.makeText(getApplicationContext(),"worng",Toast.LENGTH_SHORT).show();
                }
            }
        });
        

    }
}