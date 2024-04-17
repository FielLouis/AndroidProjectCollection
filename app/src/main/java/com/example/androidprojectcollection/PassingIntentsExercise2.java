package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Objects;

public class PassingIntentsExercise2 extends AppCompatActivity {
    TextView tvFname, tvLname, tvGender, tvBirthDate, tvPhoneNumber, tvEmail, tvCourse, tvCivilStatus, tvHeight, tvWeight, tvMunicipality, tvZIP, tvProvince;
    Button btnReturn;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passing_intents_exercise2);
        Objects.requireNonNull(getSupportActionBar()).hide();

        tvFname = findViewById(R.id.tvFname2);
        tvLname = findViewById(R.id.tvLname2);
        tvGender = findViewById(R.id.tvGender2);
        tvBirthDate = findViewById(R.id.tvBirthdate2);
        tvPhoneNumber = findViewById(R.id.tvPhoneNumber2);
        tvEmail = findViewById(R.id.tvEmail2);
        tvCourse = findViewById(R.id.tvCourse2);
        tvCivilStatus = findViewById(R.id.tvCivilStatus2);
        tvHeight = findViewById(R.id.tvHeight2);
        tvWeight = findViewById(R.id.tvWeight2);
        tvMunicipality = findViewById(R.id.tvMunicipality2);
        tvZIP = findViewById(R.id.tvZIP2);
        tvProvince = findViewById(R.id.tvProvince2);

        Intent intent = getIntent();

        String fname = intent.getStringExtra("fname_key");
        String lname = intent.getStringExtra("lname_key");
        String gender = intent.getStringExtra("gender_key");
        String bday = intent.getStringExtra("bday_key");
        String pNumber = intent.getStringExtra("pNumber_key");
        String emailAdd = intent.getStringExtra("emailAdd_key");
        String course = intent.getStringExtra("course_key");
        String civilStatus = intent.getStringExtra("civilStatus_key");
        String height = intent.getStringExtra("height_key");
        String weight = intent.getStringExtra("weight_key");
        String municipality = intent.getStringExtra("municipality_key");
        String zip = intent.getStringExtra("zip_key");
        String province = intent.getStringExtra("province_key");

        tvFname.setText(fname);
        tvLname.setText(lname);
        tvGender.setText(gender);
        tvBirthDate.setText(bday);
        tvPhoneNumber.setText(pNumber);
        tvEmail.setText(emailAdd);
        tvCourse.setText(course);
        tvCivilStatus.setText(civilStatus);
        tvHeight.setText(height);
        tvWeight.setText(weight);
        tvMunicipality.setText(municipality);
        tvZIP.setText(zip);
        tvProvince.setText(province);

        btnReturn = findViewById(R.id.btnReturn2);
        btnReturn.setOnClickListener(view -> {
            Intent intentRet = new Intent(PassingIntentsExercise2.this, PassingIntentsExercise.class);
            startActivity(intentRet);
        });
    }
}