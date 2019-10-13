package com.example.myapplication3;

import android.annotation.SuppressLint;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.view.Display;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;
import android.widget.ImageView;

public class Canvas extends View {

    private ViewGroup mainLayout;
    private Bitmap bgImage;
    private Bitmap glove;

    private int xDelta;
    private int yDelta;

    private int blueX;
    private int blueY;
    private int blueSpeed = 15;
    private Paint bluePaint = new Paint();

    private int canvasWidth;
    private int canvasHeight;

    public Canvas (Context context) {
        super (context);

        glove = BitmapFactory.decodeResource(getResources(), R.drawable.glove);
        bgImage = BitmapFactory.decodeResource(getResources(), R.drawable.grass);

        bluePaint.setColor(Color.BLUE);
        bluePaint.setAntiAlias(false);
    }

    @Override
    protected void onDraw(android.graphics.Canvas canvas) {
        canvas.drawBitmap(bgImage, 0 , 0 , null);

        canvas.drawBitmap(glove, 0,0, null);

        blueX -= blueSpeed;
        if(blueX < 0) {
            blueX = canvas.getWidth() + 20;
            blueY = (int) Math.floor(Math.random() * (canvas.getHeight() - canvas.getHeight() - 10)) + canvas.getHeight() - 10;
        }
        canvas.drawCircle(blueX, blueY, 10, bluePaint);
    }


    private OnTouchListener onTouchListener() {
        return new OnTouchListener() {
            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                final int x = (int) event.getRawX();
                final int y = (int) event.getRawY();

                switch (event.getAction() & MotionEvent.ACTION_MASK) {
                    case MotionEvent.ACTION_DOWN:
                        RelativeLayout.LayoutParams lParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
                        xDelta = x - lParams.leftMargin;
                        yDelta = y - lParams.topMargin;
                        break;

                    case MotionEvent.ACTION_UP:
                        break;

                    case MotionEvent.ACTION_MOVE:
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
                        layoutParams.leftMargin = x - xDelta;
                        layoutParams.topMargin = y - yDelta;
                        layoutParams.rightMargin = 0;
                        layoutParams.bottomMargin = 0;
                        view.setLayoutParams(layoutParams);
                        break;
                }

                mainLayout.invalidate();
                return true;
            }
        };
    }

    private void blinkingEffect() {
        final Handler handler = new Handler();
        new Thread(new Runnable() {
            @Override
            public void run() {
                //1000 millisecond = 1 sec
                int blinkTime = 1000;
                try{Thread.sleep(blinkTime);}     catch (Exception e) {}
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        //Finds text and makes it disappear
                        TextView text = findViewById(R.id.text);

                        if(text.getVisibility() == View.VISIBLE){
                            text.setVisibility(View.INVISIBLE);
                        }
                        else{
                            //Makes text reappear
                            text.setVisibility(View.VISIBLE);
                        }
                        blinkingEffect();
                    }
                });
            }
        }).start();
    }

}
