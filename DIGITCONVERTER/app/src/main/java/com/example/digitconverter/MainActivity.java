package com.example.digitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b=findViewById(R.id.binary);
        Button d=findViewById(R.id.decimal);
        Button o=findViewById(R.id.ocatal);
        Button h=findViewById(R.id.hex);
        Button c=findViewById(R.id.clear);


        TextView op=findViewById(R.id.output);

        EditText ip=findViewById(R.id.input);




        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    String input = ip.getText().toString().trim();

                    int decimalValue = Integer.parseInt(input);
                    String binary = Integer.toBinaryString(decimalValue);
                    String result = "Binary: " + binary;
                    op.setText(result);
                } catch (NumberFormatException e) {
                    op.setText("Invalid input. Please enter a valid number.");
                }
            }
        });



        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String input = ip.getText().toString().trim();
                    int decimalValue = Integer.parseInt(input);
                    String result = "Decimal: " + decimalValue;
                    op.setText(result);
                } catch (NumberFormatException e) {
                    op.setText("Invalid input. Please enter a valid number.");
                }

            }
        });

        o.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    String input = ip.getText().toString().trim();
                    int decimalValue = Integer.parseInt(input);
                    String octal = Integer.toOctalString(decimalValue);
                    String result = "octal: " + octal;
                    op.setText(result);
                } catch (NumberFormatException e) {
                    op.setText("Invalid input. Please enter a valid number.");
                }
            }
        });

        h.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String input = ip.getText().toString().trim();
                    int decimalValue = Integer.parseInt(input);
                    String hexadecimal = Integer.toHexString(decimalValue);
                    String result = "hexaDecimal: " + hexadecimal;
                    op.setText(result);
                } catch (NumberFormatException e) {
                    op.setText("Invalid input. Please enter a valid number.");
                }
            }
        });


        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ip.setText("");
                op.setText("");
            }
        });

    }
}