package com.example.snake;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Snake {
    private int x;
    private int y;
    private int speedX;
    private int speedY;
    private int cellSize;

    public Snake(int x, int y, int speedX, int speedY, int cellSize) {
        this.x = x;
        this.y = y;
        this.speedX = speedX;
        this.speedY = speedY;
        this.cellSize = cellSize;
    }

    public void dir(int x, int y) {
        speedX = x;
        speedY = y;
    }

    public void update(int width, int height) {
        int newX = x + speedX * cellSize;

        if (newX >= 0 && width >= newX + cellSize) {
            x = newX;
        }

        int newY = y + speedY * cellSize;

        if (newY >= 0 && height >= newY + cellSize) {
            y = newY;
        }
    }

    public void show(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(Color.WHITE);

        canvas.drawRect(x, y, x + cellSize, y + cellSize, paint);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
