package com.example.snake;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Snake {
    private int x;
    private int y;
    private int speedX;
    private int speedY;
    private int size = 10;

    public Snake(int x, int y, int speedX, int speedY, float density) {
        this.x = x;
        this.y = y;
        this.speedX = speedX;
        this.speedY = speedY;
        this.size *= density;
    }

    public void dir(int x, int y) {
        speedX = x;
        speedY = y;
    }

    public void update(int width, int height) {
        int newX = x + speedX * size;

        if (newX >= 0 && width >= newX + size) {
            x = newX;
        }

        int newY = y + speedY * size;

        if (newY >= 0 && height >= newY + size) {
            y = newY;
        }
    }

    public void show(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(Color.WHITE);

        canvas.drawRect(x, y, x + size, y + size, paint);
    }
}
