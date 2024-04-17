package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.Objects;

public class PassingIntentsExercise2 extends AppCompatActivity {
    TextView tvFname, tvLname, tvGender, tvBirthDate, tvPhoneNumber, tvEmail, tvCourse, tvCivilStatus, tvHeight, tvWeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passing_intents_exercise2);
        Objects.requireNonNull(getSupportActionBar()).hide();




    }
}