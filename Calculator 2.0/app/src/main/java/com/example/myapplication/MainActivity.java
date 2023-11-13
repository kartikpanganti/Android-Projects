package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Stack;

public class MainActivity extends AppCompatActivity {

    String temp,display,result;
    int a=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InfixToPostfix converter=new InfixToPostfix();
        InfixToPrefixConverter inpre=new InfixToPrefixConverter();
        PrefixEvaluator evalpre=new PrefixEvaluator();
        InfixToPrefix inpreeval=new InfixToPrefix();

//        BUTTON VARIABLE DECARATION======================================================================================

        Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, pl, mi, di, mu, eq, ba, br, cl, po,sq;
        TextView input,output;

//        BUTTON ID Config=================================================================================================

        // NUMBERS BUTTONS--------------------------------
        b0 = findViewById(R.id.n0);
        b1 = findViewById(R.id.n1);
        b2 = findViewById(R.id.n2);
        b3 = findViewById(R.id.n3);
        b4 = findViewById(R.id.n4);
        b5 = findViewById(R.id.n5);
        b6 = findViewById(R.id.n6);
        b7 = findViewById(R.id.n7);
        b8 = findViewById(R.id.n8);
        b9 = findViewById(R.id.n9);

        // OPERATION BUTTON--------------------------------
        pl = findViewById(R.id.addition);
        mi = findViewById(R.id.substraction);
        mu = findViewById(R.id.multiplication);
        di = findViewById(R.id.division);
        br = findViewById(R.id.nB);
        ba = findViewById(R.id.backspace);
        eq = findViewById(R.id.equal);
        po = findViewById(R.id.nD);
        cl = findViewById(R.id.clear);
        sq = findViewById(R.id.square);

        // DISPLAY -------------------------------------------
        input=findViewById(R.id.ip);
        output=findViewById(R.id.op);


 // Buttons Action Code===================================================================================================

        //NUMERIC BUTTONS  %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

        // BUTTON (.)_______________________________________________________________
        po.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText(input.getText() + ".");
            }
        });

        // BUTTON (0)_______________________________________________________________
        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText(input.getText() + "0");
            }
        });

        // BUTTON (1)_______________________________________________________________
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText(input.getText() + "1");
            }
        });

        // BUTTON (2)_______________________________________________________________
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText(input.getText() + "2");
            }
        });

        // BUTTON (3)_______________________________________________________________
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText(input.getText() + "3");
            }
        });

        // BUTTON (4)_______________________________________________________________
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText(input.getText() + "4");
            }
        });

        // BUTTON (5)_______________________________________________________________
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText(input.getText() + "5");
            }
        });

        // BUTTON (6)_______________________________________________________________
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText(input.getText() + "6");
            }
        });

        // BUTTON (7)_______________________________________________________________
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText(input.getText() + "7");
            }
        });

        // BUTTON (8)_______________________________________________________________
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText(input.getText() + "8");
            }
        });

        // BUTTON (9)_______________________________________________________________
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText(input.getText() + "9");
            }
        });


        //OPERATIONAL BUTTON    %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
        // BUTTON (+)_______________________________________________________________
       pl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText(input.getText() + "+");
            }
        });

        // BUTTON (–)_______________________________________________________________
        mi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText(input.getText() + "-");
            }
        });

        // BUTTON (×)_______________________________________________________________
        mu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText(input.getText() + "*");
            }
        });

        // BUTTON (÷)_______________________________________________________________
        di.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText(input.getText() + "/");
            }
        });

        // BUTTON (x²)_______________________________________________________________
        sq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText(input.getText() + "²");
            }
        });

        // BUTTON (⌫)_______________________________________________________________
        try {
            ba.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String bcdp = input.getText().toString();
                    StringBuffer sb = new StringBuffer(bcdp);
                    if (sb.length() == 0)
                        input.setText("");
                    else
                        sb.deleteCharAt(sb.length() - 1);
                    input.setText(sb);
                }
            });
        } catch (Exception e) {
            input.setText("");
        }

        // BUTTON (C)_________________________________________________________________
        cl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.setText("");
                output.setText("");
            }
        });

        // BUTTON ( () )_______________________________________________________________
        br.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (a % 2 == 0) {
                    temp = input.getText().toString();
                    input.setText(temp + "(");
                    a %= 2;
                    a++;
                } else if (a % 2 == 1) {
                    temp = input.getText().toString();
                    input.setText(temp + ")");
                    a %= 2;
                    a++;
                }

            }
        });

        // BUTTON (=)_______________________________________________________________
        eq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //EVALUATE BY InfixToPostfix======================

//                temp=input.getText().toString();
//                String con=converter.infixToPostfix(temp);
//                int res=converter.evaluatePostfix(con);
//                output.setText(Integer.toString(res));
//


                //EVALUATE BY InfixToPrefix======================

                temp=input.getText().toString();
                String pre=inpreeval.infixToPrefix(temp);
                float res=inpreeval.evaluatePrefix(pre);
                output.setText(Float.toString(res));
            }
        });





    }
}
