package com.example.snake;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.util.LinkedList;

public class Snake {

    // head is on position 0 in list
    private LinkedList<Position> cells;

    private int speedX;
    private int speedY;
    private int cellSize;

    public Snake(int x, int y, int speedX, int speedY, int cellSize) {

        cells = new LinkedList<>();
        cells.add(new Position(x, y));
        this.speedX = speedX;
        this.speedY = speedY;
        this.cellSize = cellSize;
    }

    public void dir(int x, int y) {
        speedX = x;
        speedY = y;
    }

    public void addCell(int x, int y) {
        cells.add(new Position(x, y));
    }

    public void update(int width, int height) {
        int newX = cells.getFirst().getX() + speedX * cellSize;

        int newY = cells.getFirst().getY() + speedY * cellSize;

        if (newX >= 0 && width >= newX + cellSize && newY >= 0 && height >= newY + cellSize) {

            for (int i = cells.size() - 1; i > 0; i--) {
                cells.set(i, cells.get(i - 1));
            }

            cells.set(0, new Position(newX, newY));
        }
    }

    public void show(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(Color.WHITE);

        for (Position position : cells) {
            canvas.drawRect(position.getX(), position.getY(),
                    position.getX() + cellSize, position.getY() + cellSize, paint);
        }
    }

    public int getHeadX() {
        return cells.getFirst().getX();
    }

    public int getHeadY() {
        return cells.getFirst().getY();
    }
}
