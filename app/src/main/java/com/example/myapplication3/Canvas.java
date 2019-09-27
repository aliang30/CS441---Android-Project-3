package com.example.myapplication3;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

public class Canvas extends View {

    Paint paint;
    Rect rect;

    public Canvas(Context context) {
        super(context);
        paint = new Paint();
        rect = new Rect();
    }

    @Override
    protected void onDraw(android.graphics.Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(3);

        canvas.drawRect(2, 2, canvas.getWidth()/2,canvas.getHeight()/2,paint);
    }
}
