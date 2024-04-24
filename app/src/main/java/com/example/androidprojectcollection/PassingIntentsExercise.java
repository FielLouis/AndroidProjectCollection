package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.util.Objects;

public class PassingIntentsExercise extends AppCompatActivity {
    Button btnSubmit, btnClear;
    EditText etxtFname, etxtLname, etxtBDate, etxtPhoneNumber, etxtEmailAddress, etxtHeight, etxtWeight, etxtMunicipality, etxtZIPCode, etxtProvince;
    RadioButton rbMale, rbFemale, rbGenderOther;
    RadioButton rbSingle, rbMarried, rbCivilOther, rbPreferNotToSay;
    Spinner spinner;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passing_intents_exercise);
        Objects.requireNonNull(getSupportActionBar()).hide();

        // finding the elements through ID
        etxtFname = findViewById(R.id.etxtFirstName);
        etxtLname = findViewById(R.id.etxtLastName);
        etxtBDate = findViewById(R.id.etxtBdate);
        etxtPhoneNumber = findViewById(R.id.etxtPhoneNumber);
        etxtEmailAddress = findViewById(R.id.etxtEmail);
        etxtHeight = findViewById(R.id.etxtHei);
        etxtWeight = findViewById(R.id.etxtWei);
        etxtMunicipality = findViewById(R.id.etxtMunicipality);
        etxtZIPCode = findViewById(R.id.etxtZIP);
        etxtProvince = findViewById(R.id.etxtProvince);

        rbMale = findViewById(R.id.rbMale);
        rbFemale = findViewById(R.id.rbFemale);
        rbGenderOther = findViewById(R.id.rbGenderOther);
        rbSingle = findViewById(R.id.rbSingle);
        rbMarried = findViewById(R.id.rbMarried);
        rbCivilOther = findViewById(R.id.rbCivilOther);
        rbPreferNotToSay = findViewById(R.id.rbCivilPreferNotToSay);

        spinner = findViewById(R.id.spCourseSelect);

        btnSubmit = findViewById(R.id.btnSubmitForm);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fname = etxtFname.getText().toString();
                String lname = etxtLname.getText().toString();

                String gender;
                if(rbMale.isChecked()) {
                    gender = "Male";
                } else if(rbFemale.isChecked()) {
                    gender = "Female";
                } else if(rbGenderOther.isChecked()) {
                    gender = "Other";
                } else {
                    gender = "Unknown";
                }

                String bDate = etxtBDate.getText().toString();
                String pNumber = etxtPhoneNumber.getText().toString();
                String emailAdd = etxtEmailAddress.getText().toString();
                String course = spinner.getSelectedItem().toString();

                String civilStatus;
                if(rbSingle.isChecked()) {
                    civilStatus = "Single";
                } else if (rbMarried.isChecked()) {
                    civilStatus = "Married";
                } else if (rbCivilOther.isChecked()) {
                    civilStatus = "Other";
                } else if (rbPreferNotToSay.isChecked()) {
                    civilStatus = "Prefer not to say";
                } else {
                    civilStatus = "Unknown";
                }

                String height = etxtHeight.getText().toString() + " cms";
                String weight = etxtWeight.getText().toString() + " kgs";
                String municipality = etxtMunicipality.getText().toString();
                String zip = etxtZIPCode.getText().toString();
                String province = etxtProvince.getText().toString();

                Intent intent = new Intent(PassingIntentsExercise.this, PassingIntentsExercise2.class);

                intent.putExtra("fname_key", fname);
                intent.putExtra("lname_key", lname);
                intent.putExtra("gender_key", gender);
                intent.putExtra("bday_key", bDate);
                intent.putExtra("pNumber_key", pNumber);
                intent.putExtra("emailAdd_key", emailAdd);
                intent.putExtra("course_key", course);
                intent.putExtra("civilStatus_key", civilStatus);
                intent.putExtra("height_key", height);
                intent.putExtra("weight_key", weight);
                intent.putExtra("municipality_key", municipality);
                intent.putExtra("zip_key", zip);
                intent.putExtra("province_key", province);

                startActivity(intent);
            }
        });

        btnClear = findViewById(R.id.btnClearForm);
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etxtFname.setText("");
                etxtLname.setText("");

                rbMale.setChecked(false);
                rbFemale.setChecked(false);
                rbGenderOther.setChecked(false);

                etxtBDate.setText("");
                etxtPhoneNumber.setText("");
                etxtEmailAddress.setText("");

                rbSingle.setChecked(false);
                rbMarried.setChecked(false);
                rbCivilOther.setChecked(false);
                rbPreferNotToSay.setChecked(false);

                etxtHeight.setText("");
                etxtWeight.setText("");
                etxtMunicipality.setText("");
                etxtZIPCode.setText("");
                etxtProvince.setText("");
            }
        });

    }

}