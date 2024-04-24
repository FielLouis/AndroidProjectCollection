package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    Button btnLayoutExercise, btnButtonExercise, btnCalculatorExercise, btnColorMatch, btnConnect3, btnPassingIntents, btnMenu;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_main);

        btnLayoutExercise = (Button) findViewById(R.id.btnLayoutExercise);
        btnLayoutExercise.setOnClickListener(view -> {        //this activity         //destination activity
            Intent intent1 = new Intent(MainActivity.this, LayoutExercise.class);
            startActivity(intent1);
        });

        btnButtonExercise = (Button) findViewById(R.id.btnButtonExercise);
        btnButtonExercise.setOnClickListener(view -> {
            Intent intent2 = new Intent(MainActivity.this, ButtonExercise.class);
            startActivity(intent2);
        });

        btnCalculatorExercise = (Button) findViewById(R.id.btnCalculatorExercise);
        btnCalculatorExercise.setOnClickListener(view -> {
            Intent intent3 = new Intent(MainActivity.this, CalculatorExercise.class);
            startActivity(intent3);
        });

        btnColorMatch = (Button) findViewById(R.id.btnColorMatch);
        btnColorMatch.setOnClickListener(view -> {
            Intent intent4 = new Intent(MainActivity.this, ColorMatch_Midterm.class);
            startActivity(intent4);
        });

        btnConnect3 = (Button) findViewById(R.id.btnConnect3);
        btnConnect3.setOnClickListener(view -> {
            Intent intent5 = new Intent(MainActivity.this, Connect3Exercise.class);
            startActivity(intent5);
        });

        btnPassingIntents = (Button) findViewById(R.id.btnPassingIntents);
        btnPassingIntents.setOnClickListener(view -> {
            Intent intent6 = new Intent(MainActivity.this, PassingIntentsExercise.class);
            startActivity(intent6);
        });

        btnMenu = (Button) findViewById(R.id.btnMenu);
        btnMenu.setOnClickListener(view -> {
            Intent intent7 = new Intent(MainActivity.this, MenuExercise.class);
            startActivity(intent7);
        });
    }
}