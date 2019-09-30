package com.example.myapplication3;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends Activity {

    Canvas canvasObj;
    private ViewGroup mainLayout;
    private ImageView image1;

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
        image1 = (ImageView) findViewById(R.id.image1);
        image1.setOnTouchListener(onTouchListener());
    }

    private OnTouchListener onTouchListener() {
        return onTouch(view, event) -> {
            final int x = (int) event.getRawX();
            final int y = (int) event.getRawY();

            switch (event.getAction() & MotionEvent.ACTION_MASK) {
                case MotionEvent.ACTION_DOWN:
                    RelativeLayout.LayoutParams lParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
                    xDelta = x - lParams.leftMargin;
                    yDelta = y - lParams.topMargin;
                    break;

                case MotionEvent.ACTION_MOVE:
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
                    layoutParams.leftMargin = x - xDelta;
                    layoutParams.rightMargin = y - yDelta;
                    layoutParams.rightMargin = 0;
                    layoutParams.bottomMargin = 0;
                    view.setLayoutParams(layoutParams);
                    break;
            }
            mainLayout.invalidate();
            return true;
        };
    }

}
