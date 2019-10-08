package com.example.myapplication3;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.MotionEvent;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.RelativeLayout;


public class MainActivity extends Activity {

    private ViewGroup mainLayout;
    private ImageView image;

    private int xDelta;
    private int yDelta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        canvasObj = new Canvas(this);

        setContentView(canvasObj);
        */

        mainLayout = (RelativeLayout) findViewById(R.id.main);
        image = findViewById(R.id.soccer);

        image.setOnTouchListener(onTouchListener());
        blinkingEffect();
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