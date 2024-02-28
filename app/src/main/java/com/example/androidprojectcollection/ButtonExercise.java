package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.Objects;
import java.util.Random;

public class ButtonExercise extends AppCompatActivity {
    Button btnClose, btnToast, btnChangeBG, btnChangeBtnBG, btnDisappear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_exercise);
        Objects.requireNonNull(getSupportActionBar()).hide();

        CharSequence text = "Toast is good";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(this, text, duration);

        Random r = new Random();

        btnClose = (Button) findViewById(R.id.btnClose);
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int1 = new Intent(ButtonExercise.this, ReturnButton.class);
                startActivity(int1);
            }
        });

        btnToast = (Button) findViewById(R.id.btnToast);
        btnToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toast.show();
            }
        });

        btnChangeBG = (Button) findViewById(R.id.btnChangeBG);
        View v = findViewById(R.id.ButtonExercise);
        btnChangeBG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                v.setBackgroundColor(Color.argb(255, r.nextInt(255), r.nextInt(255), r.nextInt(255)));
            }
        });

        btnChangeBtnBG = (Button) findViewById(R.id.btnChangeBtnBG);
        btnChangeBtnBG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setBackgroundColor(Color.argb(255, r.nextInt(255), r.nextInt(255), r.nextInt(255)));
            }
        });

        btnDisappear = (Button) findViewById(R.id.btnDisappear);
        btnDisappear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnDisappear.setVisibility(View.INVISIBLE);
            }
        });
    }
}