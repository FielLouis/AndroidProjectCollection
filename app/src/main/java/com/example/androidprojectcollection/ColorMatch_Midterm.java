package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Objects;
import java.util.Random;

public class ColorMatch_Midterm extends AppCompatActivity {
    boolean isWin, toastDone;
    Button[][] btn;
    Button btnReturn, btnToWin;
    int[] colors = {Color.RED, Color.BLUE, Color.GREEN}; // 0 - Red // 1 - Blue // 2 - Green
    int[][] btnColors;

    private void start() {
        isWin = false;
        toastDone = false;
        randomizeColors();
    }

    private void randomizeColors() {
        Random r = new Random();
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                int num = r.nextInt(3);
                btn[i][j].setBackgroundColor(colors[num]);
                btnColors[i][j] = num;
            }
        }

    }

    private void checkWin() {
        int colorToMatch = btnColors[0][0];

        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(colorToMatch != btnColors[i][j]) {
                    isWin = false;
                    return;
                }
                isWin = true;
            }
        }
    }

    private void changeColor(Button btn, int num) {
        btn.setBackgroundColor(colors[num]);
    }

    public int getButtonColor(int row, int col) {
        int result = btnColors[row][col] + 1;

        if(result > 2) {
            result = 0;
        }

        btnColors[row][col] = result;
        return result;
    }

    private void winGame() {
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                btn[i][j].setBackgroundColor(colors[0]);
                btnColors[i][j] = 0;
            }
        }

        btn[0][1].setBackgroundColor(colors[2]);
        btnColors[0][1] = 2;
        btn[1][0].setBackgroundColor(colors[2]);
        btnColors[1][0] = 2;
        btn[1][2].setBackgroundColor(colors[2]);
        btnColors[1][2] = 2;
        btn[2][1].setBackgroundColor(colors[2]);
        btnColors[2][1] = 2;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_match_midterm);
        Objects.requireNonNull(getSupportActionBar()).hide();

        btnColors = new int[][] {
                {0, 0, 0}, {0, 0, 0}, {0, 0, 0}
        };

        btn = new Button[][] {
                {findViewById(R.id.btn11), findViewById(R.id.btn12), findViewById(R.id.btn13)},
                {findViewById(R.id.btn21), findViewById(R.id.btn22), findViewById(R.id.btn23)},
                {findViewById(R.id.btn31), findViewById(R.id.btn32), findViewById(R.id.btn33)}
        };

        btnReturn = findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                start(); // restarts
            }
        });

        btnToWin = findViewById(R.id.btnToWin);
        btnToWin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                winGame();
            }
        });

        start(); // starts

        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                int finalI = i;
                int finalJ = j;
                btn[i][j].setOnClickListener(new View.OnClickListener() {
                    int colorToChange;
                    @Override
                    public void onClick(View view) {
                        if(!isWin) {
                            if(finalI + 1 < 3) {
                                colorToChange = getButtonColor(finalI + 1, finalJ);
                                changeColor(btn[finalI + 1][finalJ], colorToChange); //bottom sa button pressed
                            }

                            if(finalI - 1 != -1) {
                                colorToChange = getButtonColor(finalI - 1, finalJ);
                                changeColor(btn[finalI - 1][finalJ], colorToChange); //top sa button pressed
                            }

                            if(finalJ + 1 < 3) {
                                colorToChange = getButtonColor(finalI, finalJ + 1);
                                changeColor(btn[finalI][finalJ + 1], colorToChange); //right sa button pressed
                            }

                            if(finalJ - 1 != -1) {
                                colorToChange = getButtonColor(finalI, finalJ - 1);
                                changeColor(btn[finalI][finalJ - 1], colorToChange); //left sa button pressed
                            }

                        }

                        checkWin();
                        if(isWin && !toastDone) {
                            toastDone = true;
                            Toast.makeText(ColorMatch_Midterm.this, "You WON YIPEE", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        }
    }
}