package com.example.myapplication3;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class Canvas extends View {

    Paint paint = new Paint();

    public void init() {

        paint.setColor(Color.rgb(34, 139, 34));
    }

    public Canvas(Context context) {
        super(context);
        init();
    }

    public Canvas(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Canvas(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    @Override
    protected void onDraw(android.graphics.Canvas canvas) {
        super.onDraw(canvas);
        float x, y;

        x = getWidth();
        y = getHeight();

        paint.setStyle(Paint.Style.FILL);

        canvas.drawPaint(paint);

        paint.setColor(Color.WHITE);

        canvas.drawCircle(x/2, y/2, 50, paint);

        paint.setColor(Color.WHITE);

        canvas.drawLine(540, 0, 540, 1500, paint);

        paint.setColor(Color.WHITE);

        canvas.drawLine(0, 80, 1500, 80, paint);
        paint.setColor(Color.WHITE);
        canvas.drawLine(0, 1420, 1500, 1420, paint);
    }


}
