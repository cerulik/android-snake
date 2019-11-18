package com.example.snake;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

public class SnakeView extends View {

    private Snake snake;
    private RandomFood food;
    private int width, height = 0, cellSize = 10;
    private int eatenFoodCounter = 0;

    public SnakeView(Context context) {
        super(context);
        init();
    }

    public SnakeView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SnakeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setBackgroundColor(Color.BLACK);
        cellSize = (int) (10 * getResources().getDisplayMetrics().density);
        snake = new Snake(0, 0, 1, 0, cellSize);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        snake.update(width, height);

        if (snake.getHeadX() == food.getX() && snake.getHeadY() == food.getY()) {
            eatenFoodCounter++;
            snake.addCell(food.getX(), food.getY());
            food.nextFood(width, height);
        }

        food.show(canvas);
        snake.show(canvas);

        postInvalidateDelayed(50);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width = w;
        height = h;
        food = new RandomFood(width, height, cellSize);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }

    public void setSnakesDir(Direction direction) {
        switch (direction) {
            case UP:
                snake.dir(0, -1);
                break;
            case LEFT:
                snake.dir(-1, 0);
                break;
            case RIGHT:
                snake.dir(1, 0);
                break;
            case DOWN:
                snake.dir(0, 1);
                break;
        }
    }
}
