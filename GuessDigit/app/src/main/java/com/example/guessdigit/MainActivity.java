package com.example.guessdigit;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public int targetNum;
    public int attempts = 0,cow=0,bull=0;
    public EditText guess;
    public TextView hints;
    Random random = new Random();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         guess = findViewById(R.id.guessEditText);
         hints = findViewById(R.id.hintTextView);
         Button cl=findViewById(R.id.clear);
          cl.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  guess.setText("");
                  hints.setText("");
                  targetNum = random.nextInt(9000) + 1000;
                  attempts=0;
                  Toast toast = Toast.makeText(getApplicationContext(), "Game Restarted", Toast.LENGTH_SHORT);
                  toast.show();
              }
          });

        generateRandomNumber();

        Button guessButton = findViewById(R.id.guessButton);
        guessButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkGuess();
            }
        });
    }

    public void generateRandomNumber() {

        targetNum = random.nextInt(9000) + 1000;
    }

    public void checkGuess() {
        try {
            int gues = Integer.parseInt(guess.getText().toString());
            attempts++;

            if (gues == targetNum) {
                hints.setText("Congratulations! \n You've guessed the correct number \nin \n" + attempts + " attempts.");
            } else {
                String hint = getHint(targetNum, gues);
                hints.setText("Hint: " + hint);
            }
        }
        catch (Exception e)
        {
            hints.setText("ERROR: Enter Only 4 Digits ");
        }
    }

    public String getHint(int target, int gues) {
        String targetStr = String.valueOf(target);
        String guessStr = String.valueOf(gues);
        StringBuilder hint = new StringBuilder();

        for (int i = 0; i < 4; i++) {
            if (targetStr.charAt(i) == guessStr.charAt(i)) {
                hint.append(targetStr.charAt(i));
            } else {
                hint.append("X");
            }
        }

        return hint.toString();
}
}