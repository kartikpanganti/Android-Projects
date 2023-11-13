package com.example.mydice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        setContentView(R.layout.activity_main);

        Random rd = new Random();
        
        ImageView ig = (ImageView) findViewById(R.id.dice);
        Button bt = findViewById(R.id.rollbutton);
        TextView dicenum= findViewById(R.id.dicecount);


        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int randomNumber = rd.nextInt(6) + 1;
                switch (randomNumber) {
                    case 1:
                    {
                        ig.setImageResource(R.drawable.d1);
                        Animation animation= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate);
                        ig.startAnimation(animation);
                        dicenum.setText(Integer.toString(randomNumber));
                        break;
                    }
                    case 2:
                    {
                        ig.setImageResource(R.drawable.d2);
                        Animation animation= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate);
                        ig.startAnimation(animation);
                        dicenum.setText(Integer.toString(randomNumber));
                        break;
                    }
                    case 3:
                    {
                        ig.setImageResource(R.drawable.d3);
                        Animation animation= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate);
                        ig.startAnimation(animation);
                        dicenum.setText(Integer.toString(randomNumber));
                        break;
                    }
                    case 4:
                    {
                        Animation animation= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate);
                        ig.startAnimation(animation);
                        ig.setImageResource(R.drawable.d4);
                        dicenum.setText(Integer.toString(randomNumber));
                        break;
                    }
                    case 5:
                    {
                        ig.setImageResource(R.drawable.d5);
                        Animation animation= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate);
                        ig.startAnimation(animation);
                        dicenum.setText(Integer.toString(randomNumber));
                        break;
                    }
                    case 6:
                    {
                        ig.setImageResource(R.drawable.d6);
                        Animation animation= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate);
                        ig.startAnimation(animation);
                        dicenum.setText(Integer.toString(randomNumber));
                        break;
                    }
                    default:
                        dicenum.setText("ERROR");
                }

            }
        });
    }
}