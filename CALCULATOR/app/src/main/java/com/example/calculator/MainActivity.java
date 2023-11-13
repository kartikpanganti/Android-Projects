package com.example.calculator;

import static java.lang.Math.pow;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {

    String temp,temph,tempd,tempr,tempp,tempm;
    int op;
    float tempsq;


    int result;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

// VARIABLES DECLARATION--------------------------------------
        TextView hist=findViewById(R.id.histroytxt);




        EditText disp;
        Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,pl,mi,di,mu,eq,ba,sq,cl,po,pm;



// KEYBOARD INPUT BLOCKED--------------------------------------
        disp=findViewById(R.id.displaytxt);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
        {
            disp.setShowSoftInputOnFocus(false);
        }


// BUTTONS CODE------------------------------------------------------

        hist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String j=hist.getText().toString();
                temp=j;
                hist.setText("");
                disp.setText(j);
            }
        });


   // Numbers Buttons =================================

        b0=findViewById(R.id.n0);
        b1=findViewById(R.id.n1);
        b2=findViewById(R.id.n2);
        b3=findViewById(R.id.n3);
        b4=findViewById(R.id.n4);
        b5=findViewById(R.id.n5);
        b6=findViewById(R.id.n6);
        b7=findViewById(R.id.n7);
        b8=findViewById(R.id.n8);
        b9=findViewById(R.id.n9);

    // Operation Buttons =============================
        pl=findViewById(R.id.plus);
        mi=findViewById(R.id.minus);
        mu=findViewById(R.id.multiplication);
        di=findViewById(R.id.division);
        sq=findViewById(R.id.square);
        ba=findViewById(R.id.backspace);
        eq=findViewById(R.id.equalto);
        po=findViewById(R.id.ndot);
        cl=findViewById(R.id.clear);
        pm=findViewById(R.id.pandm);


// Buttons Action Code---------------------------------

        // BUTTON (0)_____________________________

        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                disp.setText(disp.getText()+"0");
            }
        });

        // BUTTON (1)_____________________________

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                disp.setText(disp.getText()+"1");
            }
        });

        // BUTTON (2)_____________________________

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                disp.setText(disp.getText()+"2");
            }
        });


        // BUTTON (3)_____________________________

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                disp.setText(disp.getText()+"3");
            }
        });

        // BUTTON (4)_____________________________

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                disp.setText(disp.getText()+"4");
            }
        });

        // BUTTON (5)_____________________________

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                disp.setText(disp.getText()+"5");
            }
        });

        // BUTTON (6)_____________________________

        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                disp.setText(disp.getText()+"6");
            }
        });


        // BUTTON (7)_____________________________

        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                disp.setText(disp.getText()+"7");
            }
        });

        // BUTTON (8)_____________________________

        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                disp.setText(disp.getText()+"8");
            }
        });


        // BUTTON (9)_____________________________

        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                disp.setText(disp.getText()+"9");
            }
        });

        // BUTTON (.)_____________________________

        po.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                disp.setText(disp.getText()+".");
            }
        });

        // BUTTON (+)_____________________________

        pl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                op=1;
                temp= disp.getText().toString();
                tempp=disp.getText()+"+".toString();
                disp.setText("");
            }
        });

        // BUTTON (-)_____________________________

        mi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                op=2;
                temp= disp.getText().toString();
                tempp=disp.getText()+"-".toString();
                disp.setText("");
            }
        });

        // BUTTON (÷)_____________________________

        di.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                op=4;
                temp= disp.getText().toString();
                tempp=disp.getText()+"÷".toString();
                disp.setText("");
            }
        });

        // BUTTON (×)_____________________________

        mu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                op=3;

                temp= disp.getText().toString();
                tempp=disp.getText()+"×".toString();
                disp.setText("");
            }
        });

        // BUTTON ( clear )_____________________________

        cl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                disp.setText("");
                hist.setText("");
            }
        });

        // BUTTON (x²)_____________________________

        sq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double vq = 2;
                String j = disp.getText().toString();
                disp.setText(j + "² ");
                double res = Math.pow(Double.parseDouble(j), vq);
                temp = Float.toString((float) res);
                op = 5;
            }
        });


       // BUTTON (⌫)_____________________________
        try{
        ba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            String dispp=disp.getText().toString();
            StringBuffer sb= new StringBuffer(dispp);
            if(sb.length()==0)
                disp.setText("");
            else
                sb.deleteCharAt(sb.length()-1);
            disp.setText(sb);
            }
        });}
        catch (Exception e)
        {
            disp.setText("");
        }

        try
        {
            eq.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    String a=disp.getText().toString();
                    String his= disp.getText().toString();
                    switch (op)
                    {
                        case 1:
                        {   try
                            {
                                    Float res=Float.parseFloat(temp)+Float.parseFloat(a);
                                    hist.setText(tempp+his);
                                    disp.setText(Float.toString(res));
                                    break;
                            }
                            catch (Exception e)
                            {
                                disp.setText("ERROR");
                                break;
                            }
                        }
                        case 2:
                        {
                            try
                            {
                                    Float res=Float.parseFloat(temp)-Float.parseFloat(a);
                                    hist.setText(tempp+his);
                                    disp.setText(Float.toString(res));
                                    break;
                            }
                            catch (Exception e)
                            {
                                disp.setText("ERROR");
                                break;
                            }
                        }
                        case 3:
                        {
                            try
                            {
                                    Float res=Float.parseFloat(temp)*Float.parseFloat(a);
                                    hist.setText(tempp+his);
                                    disp.setText(Float.toString(res));
                                    break;

                            }
                            catch (Exception e)
                            {
                                disp.setText("ERROR");
                                break;
                            }
                        }
                        case 4:
                        {
                            try
                            {
                                    Float res=Float.parseFloat(temp)/Float.parseFloat(a);
                                    hist.setText(tempp+his);
                                    disp.setText(Float.toString(res));
                                    break;
                            }
                            catch (Exception e)
                            {
                                disp.setText("ERROR");
                                break;
                            }
                        }
                        case 5:
                        {   try
                            {   String k=disp.getText().toString();
                                hist.setText(k);
                                disp.setText(temp);
                                break;
                            }
                            catch (Exception e)
                            {
                                disp.setText("ERROR");
                                break;
                            }
                        }
                        default:
                            disp.setText("ERROR");
                    }
                }
            });

        }
        catch (Exception e)
        {
            String a=disp.getText().toString();
            disp.setText(a);

        }
    }
}