package com.example.myapplication3;

import android.annotation.SuppressLint;
import android.graphics.Point;
import android.view.Display;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.MotionEvent;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends Activity {

    private ViewGroup mainLayout;
    private ImageView image;
    private Canvas canvasObj;
    private int xDelta;
    private int yDelta;

    private int screenWidth;
    private int screenHeight;
    private ImageView ball;
    private float ballX;
    private float ballY;

    private Handler handler = new Handler();
    private Timer timer = new Timer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        canvasObj = new Canvas(this);

        setContentView(canvasObj);
        */

        mainLayout = (RelativeLayout) findViewById(R.id.main);

        image = findViewById(R.id.glove);
        ball = findViewById(R.id.soccer);

        image.setOnTouchListener(onTouchListener());


        WindowManager wm = getWindowManager();
        Display disp = wm.getDefaultDisplay();
        Point size = new Point();
        disp.getSize(size);
        screenWidth = size.x;
        screenHeight = size.y;

        ball.setX(-80.0f);
        ball.setY(-80.0f);

        timer.schedule(new TimerTask() {
                           @Override
                           public void run() {
                               handler.post(new Runnable() {
                                   @Override
                                   public void run() {
                                       changePos();
                                   }
                               });
                           }
                       }, 0, 20);

        //blinking text animation
        blinkingEffect();
    }

    public void changePos() {
        //ball speed
        ballY = ballY - 50;

        if(ball.getY() + ball.getHeight() < 0) {
            ballX = (float) Math.floor(Math.random() * (screenWidth - ball.getWidth()));
            ballY = screenHeight + 100.0f;
        }
        ball.setX(ballX);
        ball.setY(ballY);
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