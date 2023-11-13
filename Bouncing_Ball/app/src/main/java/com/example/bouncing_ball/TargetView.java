package com.example.bouncing_ball;

import static android.graphics.Color.*;

import android.content.Context;
import android.graphics.Canvas;

import android.graphics.Paint;
import android.view.View;

public class TargetView extends View {
    public TargetView(Context context) {
        super(context);
    }
    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        int centerX = width / 10;
        int centerY = height-100;
        int targetRadius = Math.min(width, height) / 2 - 20;
        Paint paint=new Paint();


        paint.setColor(RED);
        canvas.drawCircle(centerX,centerY,75,paint);
    }
}
