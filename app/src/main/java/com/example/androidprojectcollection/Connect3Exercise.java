package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Objects;

public class Connect3Exercise extends AppCompatActivity {
    boolean isWin, toastDone;
    Button[][] btn;
    Button btnRestart;
    int[] player = {Color.RED, Color.YELLOW};
    int playerTurn;
    int btnColors[][];

    private void start() {
        isWin = false;
        toastDone = false;
        playerTurn = 1;     // 1 - Player Red ; 2 - Player Yellow

        btnColors = new int[][] {
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}
        };

        for(int row = 0; row < 5; row++) {
            for(int col = 0; col < 5; col++) {
                btn[row][col].setBackgroundColor(Color.WHITE);
            }
        }
    }

    private void dropCoin(int row, int col) {
        if(row + 1 < 5 && btnColors[row + 1][col] == 0) {
            row++;
            dropCoin(row, col);
        } else {
            //returns to avoid overlapping of colors if topmost layer is already filled
            if(btnColors[row][col] != 0) {
                return;
            }

            btnColors[row][col] = playerTurn;
            paintCell(row, col, playerTurn);
        }
    }

    private void paintCell(int row, int col, int playerColor) {
        btn[row][col].setBackgroundColor(player[playerColor - 1]);

        //check for win
        checkBoard(playerColor);

        //if win na, no need to change player
        if(isWin) {
            return;
        }

        //change Player
        if(playerTurn != 1) {
            playerTurn = 1;
        } else {
            playerTurn = 2;
        }
    }

    private void checkBoard(int playerColor) {
        int count;
        //check for vertical
        for(int i = 0; i < 5; i++) {
            count = 0;
            for(int j = 0; j < 5; j++) {
                if(btnColors[i][j] == playerColor) {
                    count++;
                } else {
                    count = 0;
                }

                if(count == 3) {
                    isWin = true;
                    return;
                }
            }
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect3_exercise);
        Objects.requireNonNull(getSupportActionBar()).hide();

        btn = new Button[5][5];

        for(int row = 0; row < 5; row++) {
            for(int col = 0; col < 5; col++) {
                String resIDname = "btn" + (row + 1) + (col + 1);
                btn[row][col] = findViewById(this.getResources().getIdentifier(resIDname, "id", this.getPackageName()));

                if(row != 0) {
                    btn[row][col].setEnabled(false);    //make only the topmost row of buttons clickable
                }
            }
        }

        btnRestart = findViewById(R.id.btnReset);
        btnRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                start();    //restarts
            }
        });

        start();    //starts

        for(int row = 0; row < 5; row++) {
            for(int col = 0; col < 5; col++) {
                int finalRow = row;
                int finalCol = col;
                btn[row][col].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(!isWin) {
                            dropCoin(finalRow, finalCol);
                        }

                        if(!toastDone && isWin) {
                            toastDone = true;
                            Toast.makeText(Connect3Exercise.this, playerTurn + "! You WON YIPEE", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        }
    }
}