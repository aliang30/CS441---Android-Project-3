package com.example.myapplication3;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    Canvas canvasObj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        canvasObj = new Canvas(this);

        canvasObj.setBackgroundColor(Color.GREEN);

        setContentView(canvasObj);
    }

}
