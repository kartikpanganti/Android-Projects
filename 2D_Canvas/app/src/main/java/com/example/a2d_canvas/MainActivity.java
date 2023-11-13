package com.example.a2d_canvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TargetView targetView = new TargetView(this);
        setContentView(targetView);
    }

    private class TargetView extends View {
        public TargetView(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            int width = getWidth();
            int height = getHeight();
            int centerX = width / 2;
            int centerY = height / 2;
            int targetRadius = Math.min(width, height) / 2 - 20;

            Paint paint = new Paint();


            int[] targetColors = {Color.RED, Color.WHITE, Color.RED, Color.WHITE, Color.RED};

            for (int i = 0; i < 5; i++) {
                paint.setColor(targetColors[i]);
                canvas.drawCircle(centerX, centerY, targetRadius - i * (targetRadius / 5), paint);
            }
        }
    }
}