package com.example.androidprojectcollection;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Random;

public class MenuExercise extends AppCompatActivity {
    Button btnChanger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_exercise);

        btnChanger = findViewById(R.id.btnTransformingButton);
    }

    private void setButton() {
        btnChanger.setBackgroundColor(Color.BLUE);
        btnChanger.setTextColor(Color.BLACK);
        btnChanger.setTextSize(30);
        btnChanger.setText("HI!");
        btnChanger.setScaleX(1);
        btnChanger.setScaleY(1);
        btnChanger.setVisibility(View.VISIBLE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_menu_exercise, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Random r = new Random();
        if (item.getItemId() == R.id.mItemChangeButtonColor) {
            btnChanger.setBackgroundColor(Color.argb(255, r.nextInt(256), r.nextInt(256), r.nextInt(256)));
        } else if (item.getItemId() == R.id.mItemChangeButtonTextColor) {
            btnChanger.setTextColor(Color.argb(255, r.nextInt(256), r.nextInt(256), r.nextInt(256)));
        } else if (item.getItemId() == R.id.mItemChangeButtonVisibility) {
            if(btnChanger.getVisibility() == View.VISIBLE) {
                btnChanger.setVisibility(View.INVISIBLE);
            } else {
                btnChanger.setVisibility(View.VISIBLE);
            }
        } else if (item.getItemId() == R.id.mItemChangeButtonSize) {
            int random_multiplier = r.nextInt(3) + 2; // 2 to 5
            float new_size = r.nextFloat() * random_multiplier;
            btnChanger.setScaleX(new_size);
            btnChanger.setScaleY(new_size);
        } else if (item.getItemId() == R.id.mItemChangeButtonText) {
            String new_text = generateRandomChars();
            btnChanger.setText(new_text);
        } else if (item.getItemId() == R.id.mItemReset) {
            Toast.makeText(this, "Reset Object Item is clicked", Toast.LENGTH_SHORT).show();
            setButton();
        } else if (item.getItemId() == R.id.mItemExit) {
            finish();
        }

        return true;
    }

    public String generateRandomChars() {
        String candidates = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()-=_+";
        StringBuilder sb = new StringBuilder ();
        Random random = new Random ();
        for (int i = 0; i < 5; i ++) {
            sb.append (candidates.charAt(random.nextInt(candidates.length())));
        }
        return sb.toString ();
    }
}