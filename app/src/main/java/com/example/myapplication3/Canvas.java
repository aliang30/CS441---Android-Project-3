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
    }

    @Override
    protected void onDraw(android.graphics.Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(2);

        canvas.drawRect(0, 0, canvas.getWidth(),canvas.getHeight()/3,paint);
    }
}
