package com.example.snake;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.util.Random;

public class RandomFood {

    private int x;
    private int y;
    private int size;
    private Random random;

    public RandomFood(int width, int height, int size) {
        random = new Random();
        this.size = size;
        nextFood(width, height);
    }

    public void nextFood(int width, int height) {
        x = random.nextInt(width / size) * size;
        y = random.nextInt(height / size) * size;
    }

    public void show(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(Color.RED);

        canvas.drawRect(x, y, x + size, y + size, paint);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
