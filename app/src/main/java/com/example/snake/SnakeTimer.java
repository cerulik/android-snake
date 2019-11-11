package com.example.snake;

import android.os.Handler;
import android.view.View;

public class SnakeTimer implements Runnable {

    private View view;
    private Handler handler;

    public SnakeTimer(View view) {
        this.view = view;
        handler = new Handler();
        handler.postDelayed(this, 1000);
    }

    @Override
    public void run() {
        view.invalidate();
        handler.postDelayed(this, 50);
    }
}
