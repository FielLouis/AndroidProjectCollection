package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;
import java.util.Stack;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Objects;

public class CalculatorExercise extends AppCompatActivity implements View.OnClickListener {
    String btnText;
    String equation = "";
    TextView tvResult, tvEquation;
    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    Button btnDot, btnAdd, btnSub, btnMul, btnDiv, btnEqu;
    boolean isFirst, firstNumber = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator_exercise);
        Objects.requireNonNull(getSupportActionBar()).hide();

        tvEquation = findViewById(R.id.tvPrevEqu);
        tvResult = findViewById(R.id.tvEqu);
        isFirst = true;

        assignButton(btn0, R.id.btnNo0);
        assignButton(btn1, R.id.btnNo1);
        assignButton(btn2, R.id.btnNo2);
        assignButton(btn3, R.id.btnNo3);
        assignButton(btn4, R.id.btnNo4);
        assignButton(btn5, R.id.btnNo5);
        assignButton(btn6, R.id.btnNo6);
        assignButton(btn7, R.id.btnNo7);
        assignButton(btn8, R.id.btnNo8);
        assignButton(btn9, R.id.btnNo9);

        assignButton(btnDot, R.id.btnDec);
        assignButton(btnAdd, R.id.btnAdd);
        assignButton(btnSub, R.id.btnMinus);
        assignButton(btnMul, R.id.btnMultiply);
        assignButton(btnDiv, R.id.btnDivide);
        assignButton(btnEqu, R.id.btnEquals);

    }

    public void assignButton(Button btn, int id) {
        btn = findViewById(id);
        btn.setOnClickListener(this);
    }

    public void clearStart(TextView tv, boolean isFirst) {
        if(!isFirst) {
            return;
        }
        tv.setText("");
        setIsFirstToFalse();
    }

    public void setFirstNumberToFalse() {
        firstNumber = false;
    }

    public void setFirstNumberToTrue() {
        firstNumber = true;
    }

    public void setIsFirstToFalse() {
        isFirst = false;
    }

    @Override
    public void onClick(View view) {
        Button btnPressed = (Button) view;
        btnText = btnPressed.getText().toString();
        equation += btnText;

        clearStart(tvResult, isFirst);

        if(tvResult.length() == 0) {
            tvResult.append(btnText);
        } else {

            if (tvResult.getText().toString().charAt(0) == '0') {
                tvResult.setText(btnText);
            } else {
                tvResult.append(btnText);
            }

        }


        System.out.println(equation);
    }
}