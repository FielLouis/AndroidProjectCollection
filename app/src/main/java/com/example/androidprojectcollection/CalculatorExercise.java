package com.example.androidprojectcollection;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Stack;

public class CalculatorExercise extends AppCompatActivity implements View.OnClickListener{

    private TextView tvEquation;
    private TextView tvResult;
    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    Button btnDot, btnAdd, btnSub, btnMul, btnDiv, btnEqu, btnClear;
    public Button assignButton(Button btn, int id) {
        btn = findViewById(id);
        btn.setOnClickListener(this);
        return btn;
    }
    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '×' || c == '÷';
    }
    private boolean isOperator(String s){
        return s.equals("+") || s.equals("-") || s.equals("×") || s.equals("÷");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator_exercise);
        Objects.requireNonNull(getSupportActionBar()).hide();

        tvEquation = findViewById(R.id.tvPrevEqu);
        tvResult = findViewById(R.id.tvEqu);

        Button[] numBtn = new Button[]{
                assignButton(btn0, R.id.btnNo0),
                assignButton(btn1, R.id.btnNo1),
                assignButton(btn2, R.id.btnNo2),
                assignButton(btn3, R.id.btnNo3),
                assignButton(btn4, R.id.btnNo4),
                assignButton(btn5, R.id.btnNo5),
                assignButton(btn6, R.id.btnNo6),
                assignButton(btn7, R.id.btnNo7),
                assignButton(btn8, R.id.btnNo8),
                assignButton(btn9, R.id.btnNo9)
        };

        Button[] opBtn = new Button[]{
                assignButton(btnAdd, R.id.btnAdd),
                assignButton(btnSub, R.id.btnMinus),
                assignButton(btnMul, R.id.btnMultiply),
                assignButton(btnDiv, R.id.btnDivide)
        };

        assignButton(btnDot, R.id.btnDec);
        assignButton(btnEqu, R.id.btnEquals);
        assignButton(btnClear, R.id.btnClear);
    }

    @Override
    public void onClick(View view) {
        Button btnPressed = (Button) view;
        String btnTxt = btnPressed.getText().toString();
        String equation = tvEquation.getText().toString();

        switch (btnTxt) {
            case "=":
                equation = calculateData(equation);
                tvResult.setText(equation);
                tvEquation.setText(equation);
                break;
            case ".":
                String last_num = "";
                for (int i = equation.length() - 1; i >= 0; i--) {
                    if (isOperator(equation.charAt(i))) {
                        break;
                    }
                    last_num += equation.charAt(i);
                }

                if (last_num.equals("")) {
                    equation += "0";
                    equation += btnTxt;
                } else if (last_num.contains(".")) {
                    if (last_num.charAt(0) == '.') {
                        equation = equation.substring(0, equation.length() - 1);
                    }

                } else {
                    equation += btnTxt;
                }

                tvEquation.setText(equation);
                break;
            case "Clear":
                tvEquation.setText("");
                tvResult.setText("");
                break;
            default:
                // Check if last input was an operation
                if (!equation.isEmpty() && isOperator(equation.charAt(equation.length() - 1)) && isOperator(btnTxt)) {
                    // Replace the last operation with the new one
                    equation = equation.substring(0, equation.length() - 1);
                }
                equation += btnTxt;
                tvEquation.setText(equation);
                if (!isOperator(btnTxt)) {
                    tvResult.setText(sequentialCalculate(equation));
                }
                break;
        }
    }
    private String calculateData(String data) {
        ArrayList<String> finalData = new ArrayList<>();
        // Extract numbers and operators
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < data.length(); i++) {
            char c = data.charAt(i);
            if (Character.isDigit(c) || c == '.') {
                temp.append(c);
            } else {
                if (temp.length() > 0) {
                    finalData.add(temp.toString());
                    temp.setLength(0);
                }
                finalData.add(String.valueOf(c));
            }
        }
        if (temp.length() > 0) {
            finalData.add(temp.toString());
        }

        // Perform operations
        Stack<String> ops = new Stack<>();
        ops.push(finalData.get(0));

        for (int i = 1; i < finalData.size(); i++) {
            switch (finalData.get(i)) {
                case "+":
                case "-":
                    ops.push(finalData.get(i));
                    break;
                case "×": {
                    double prevNum = Double.parseDouble(ops.pop());
                    double nextNum = Double.parseDouble(finalData.get(++i));
                    ops.push(String.valueOf(prevNum * nextNum));
                    break;
                }
                case "÷": {
                    double prevNum = Double.parseDouble(ops.pop());
                    double nextNum = Double.parseDouble(finalData.get(++i));
                    ops.push(String.valueOf(prevNum / nextNum));
                    break;
                }
                default:
                    ops.push(finalData.get(i));
                    break;
            }
        }
        // Calculate result
        double result = Double.parseDouble(ops.get(0));
        for (int i = 1; i < ops.size(); i += 2) {
            if (ops.get(i).equals("+")) {
                result += Double.parseDouble(ops.get(i + 1));
            } else {
                result -= Double.parseDouble(ops.get(i + 1));
            }
        }
        return String.valueOf(result);
    }

    private String sequentialCalculate(String data){

        ArrayList<String> dataToCompute = new ArrayList<>();

        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < data.length(); i++) {
            char c = data.charAt(i);
            if (Character.isDigit(c) || c == '.') {
                temp.append(c);
            } else {
                if (temp.length() > 0) {
                    dataToCompute.add(temp.toString());
                    temp.setLength(0);
                }
                dataToCompute.add(String.valueOf(c));
            }
        }
        if (temp.length() > 0) {
            dataToCompute.add(temp.toString());
        }

        Stack<String> ops = new Stack<>();
        int start = 0;
        if(isOperator(dataToCompute.get(0))){
            ops.push("0");
        } else {
            ops.push(dataToCompute.get(0));
            start = 1;
        }

        for (int i = start; i < dataToCompute.size(); i++) {
            if ( isOperator(dataToCompute.get(i))) {
                switch (dataToCompute.get(i)) {
                    case "+": {
                        double prevNum = Double.parseDouble(ops.pop());
                        double nextNum = Double.parseDouble(dataToCompute.get(++i));
                        ops.push(String.valueOf(prevNum + nextNum));
                        break;
                    }
                    case "-": {
                        double prevNum = Double.parseDouble(ops.pop());
                        double nextNum = Double.parseDouble(dataToCompute.get(++i));
                        ops.push(String.valueOf(prevNum - nextNum));
                        break;
                    }
                    case "×": {
                        double prevNum = Double.parseDouble(ops.pop());
                        double nextNum = Double.parseDouble(dataToCompute.get(++i));
                        ops.push(String.valueOf(prevNum * nextNum));
                        break;
                    }
                    case "÷": {
                        double prevNum = Double.parseDouble(ops.pop());
                        double nextNum = Double.parseDouble(dataToCompute.get(++i));
                        ops.push(String.valueOf(prevNum / nextNum));
                        break;
                    }
                }
            } else {
                ops.push(dataToCompute.get(i));
            }
        }
        return ops.pop();
    }
}