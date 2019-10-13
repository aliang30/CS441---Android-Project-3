package com.example.myapplication3;

import android.annotation.SuppressLint;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.view.Display;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class Canvas extends View {

    private ViewGroup mainLayout;
    private Bitmap bgImage;
    private Bitmap glove;

    private int xDelta;
    private int yDelta;

    private int canvasWidth;
    private int canvasHeight;

    public Canvas (Context context) {
        super (context);

        glove = BitmapFactory.decodeResource(getResources(), R.drawable.glove);
        bgImage = BitmapFactory.decodeResource(getResources(), R.drawable.grass);
    }

    @Override
    protected void onDraw(android.graphics.Canvas canvas) {
        canvas.drawBitmap(bgImage, 0, 0, null);

        canvas.drawBitmap(glove, 0, 0, null);
    }

}
