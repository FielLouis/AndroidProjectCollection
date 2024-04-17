package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_main);

        btn1 = (Button) findViewById(R.id.btnLayoutExercise);
        btn1.setOnClickListener(view -> {        //this activity         //destination activity
            Intent intent1 = new Intent(MainActivity.this, LayoutExercise.class);
            startActivity(intent1);
        });

        btn2 = (Button) findViewById(R.id.btnButtonExercise);
        btn2.setOnClickListener(view -> {
            Intent intent2 = new Intent(MainActivity.this, ButtonExercise.class);
            startActivity(intent2);
        });

        btn3 = (Button) findViewById(R.id.btnCalculatorExercise);
        btn3.setOnClickListener(view -> {
            Intent intent3 = new Intent(MainActivity.this, CalculatorExercise.class);
            startActivity(intent3);
        });

        btn4 = (Button) findViewById(R.id.btnColorMatch);
        btn4.setOnClickListener(view -> {
            Intent intent4 = new Intent(MainActivity.this, ColorMatch_Midterm.class);
            startActivity(intent4);
        });

        btn5 = (Button) findViewById(R.id.btnConnect3);
        btn5.setOnClickListener(view -> {
            Intent intent5 = new Intent(MainActivity.this, Connect3Exercise.class);
            startActivity(intent5);
        });

        btn6 = (Button) findViewById(R.id.btnPassingIntents);
        btn6.setOnClickListener(view -> {
            Intent intent6 = new Intent(MainActivity.this, PassingIntentsExercise.class);
            startActivity(intent6);
        });
    }
}