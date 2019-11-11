package com.example.snake;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private SnakeView snakeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        snakeView = findViewById(R.id.snakeView);

        findViewById(R.id.btn_up).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                snakeView.setSnakesDir(Direction.UP);
            }
        });

        findViewById(R.id.btn_left).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                snakeView.setSnakesDir(Direction.LEFT);
            }
        });

        findViewById(R.id.btn_right).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                snakeView.setSnakesDir(Direction.RIGHT);
            }
        });

        findViewById(R.id.btn_down).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                snakeView.setSnakesDir(Direction.DOWN);
            }
        });
    }
}
