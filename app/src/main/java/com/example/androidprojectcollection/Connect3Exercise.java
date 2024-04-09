package com.example.androidprojectcollection;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

@RequiresApi(api = Build.VERSION_CODES.O)
public class Connect3Exercise extends AppCompatActivity {
    boolean isWin, toastDone;
    Button[][] btn;
    Button btnRestart;
    TextView tvPlayerTurnDisplay;
    int[] player = {Color.RED, Color.GREEN};
    int playerTurn, count;
    int[][] btnColors;


    private void start() {
        isWin = false;
        toastDone = false;
        playerTurn = 2;     // 1 - Player Red ; 2 - Player Green
        count = 0;

        // 2 first for when start/restart
        swapPlayer(playerTurn);
        //after swap player 1 - Red goes first, always

        btnColors = new int[5][5];

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

            //paint button
            paintCell(row, col, playerTurn);

            //check for win
            checkBoard(playerTurn, row, col);

            //if win na, no need to change player
            if(isWin) {
                return;
            }

            //change Player
            swapPlayer(playerTurn);

        }
    }

    @SuppressLint("SetTextI18n")
    private void swapPlayer(int playerT) {
        if(playerT != 1) {
            playerTurn = 1;
            tvPlayerTurnDisplay.setText("Player Red's Turn");
        } else {
            playerTurn = 2;
            tvPlayerTurnDisplay.setText("Player Green's Turn");
        }
        tvPlayerTurnDisplay.setTextColor(player[playerTurn - 1]);
    }

    private void paintCell(int row, int col, int playerColor) {
        btn[row][col].setBackgroundColor(player[playerColor - 1]);
    }

    private void checkBoard(int playerColor, int row, int col) {
        checkBoardHorizontalBackwards(playerColor, row, col);
        checkBoardHorizontalForwards(playerColor, row, col);
        checkBoardVertical(playerColor, row, col);
        checkBoardDiagonalBackwards(playerColor, row, col);
        checkBoardDiagonalBackwardsReverse(playerColor, row, col);
        checkBoardDiagonalForwards(playerColor, row, col);
        checkBoardDiagonalForwardsReverse(playerColor, row, col);
    }

    //Helper method to check horizontal (x <- x <- x)
    private void checkBoardHorizontalBackwards(int playerColor, int row, int col) {
        if(row < 0 || col < 0) {
            count = 0;
            return;
        }

        if(btnColors[row][col] == playerColor) {
            count++;

            if(count == 3) {
                isWin = true;
                return;
            }
        } else {
            count = 0;
            return;
        }

        checkBoardHorizontalBackwards(playerColor, row, col - 1); //check behind of painted button
    }

    //Helper method to check horizontal (x -> x -> x)
    private void checkBoardHorizontalForwards(int playerColor, int row, int col) {
        if(row >= 5 || col >= 5) {
            count = 0;
            return;
        }

        if(btnColors[row][col] == playerColor) {
            count++;

            if(count == 3) {
                isWin = true;
                return;
            }
        } else {
            count = 0;
            return;
        }

        checkBoardHorizontalForwards(playerColor, row, col + 1); //check forward of painted button
    }

    //Helper method to check for vertical
    private void checkBoardVertical(int playerColor, int row, int col) {
        if(row >= 5 || col >= 5) {
            count = 0;
            return;
        }

        if(btnColors[row][col] == playerColor) {
            count++;

            if(count == 3) {
                isWin = true;
                return;
            }
        } else {
            count = 0;
            return;
        }

        checkBoardVertical(playerColor, row + 1, col); //check below of painted button
    }

    /*
    Helper method to check for diagonal leaning left
    x
      x
        x
     */
    private void checkBoardDiagonalBackwards(int playerColor, int row, int col) {
        if(row >= 5 || col >= 5) {
            count = 0;
            return;
        }

        if(btnColors[row][col] == playerColor) {
            count++;

            if(count == 3) {
                isWin = true;
                return;
            }
        } else {
            count = 0;
            return;
        }

        checkBoardDiagonalBackwards(playerColor, row + 1, col + 1); //check top left of painted button
    }

    private void checkBoardDiagonalBackwardsReverse(int playerColor, int row, int col) {
        if(row < 0 || col < 0) {
            count = 0;
            return;
        }

        if(btnColors[row][col] == playerColor) {
            count++;

            if(count == 3) {
                isWin = true;
                return;
            }
        } else {
            count = 0;
            return;
        }

        checkBoardDiagonalBackwardsReverse(playerColor, row - 1, col - 1); //check top left of painted button
    }

    /*
    Helper method to check for diagonal leaning right
        x
      x
    x
     */
    private void checkBoardDiagonalForwards(int playerColor, int row, int col) {
        if(row >= 5 || col < 0) {
            count = 0;
            return;
        }

        if(btnColors[row][col] == playerColor) {
            count++;

            if(count == 3) {
                isWin = true;
                return;
            }
        } else {
            count = 0;
            return;
        }

        checkBoardDiagonalForwards(playerColor, row + 1, col - 1); //check top right of painted button
    }

    private void checkBoardDiagonalForwardsReverse(int playerColor, int row, int col) {
        if(row < 0 || col >= 5) {
            count = 0;
            return;
        }

        if(btnColors[row][col] == playerColor) {
            count++;

            if(count == 3) {
                isWin = true;
                return;
            }
        } else {
            count = 0;
            return;
        }

        checkBoardDiagonalForwardsReverse(playerColor, row - 1, col + 1); //check top right of painted button
    }


    @SuppressLint({"DiscouragedApi", "SetTextI18n"})
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
        btnRestart.setOnClickListener(view -> {
            start();    //restarts
        });

        tvPlayerTurnDisplay = findViewById(R.id.tvPlayerTurn);

        start();    //starts

        for(int row = 0; row < 5; row++) {
            for(int col = 0; col < 5; col++) {
                int finalRow = row;
                int finalCol = col;
                btn[row][col].setOnClickListener(view -> {
                    if(!isWin) {
                        dropCoin(finalRow, finalCol);
                    }

                    if(!toastDone && isWin) {
                        toastDone = true;

                        if(playerTurn == 1) {
                            tvPlayerTurnDisplay.setText("! Player Red Wins !");
                            Toast.makeText(Connect3Exercise.this, "Player Red! You WON YIPEE", Toast.LENGTH_SHORT).show();
                        } else {
                            tvPlayerTurnDisplay.setText("! Player Green Wins !");
                            Toast.makeText(Connect3Exercise.this, "Player Green! You WON YIPEE", Toast.LENGTH_SHORT).show();
                        }
                        tvPlayerTurnDisplay.setTextColor(player[playerTurn - 1]);
                    }
                });
            }
        }
    }
}