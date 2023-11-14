package com.example.thangnvph23924_lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnB1, btnB2, btnB3, btnB4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnB1 = findViewById(R.id.btn_b1);
        btnB2 = findViewById(R.id.btn_b2);
        btnB3 = findViewById(R.id.btn_b3);
        btnB4 = findViewById(R.id.btn_b4);
        btnB1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Lab2_b1.class);
                startActivity(intent);
            }
        });
        btnB2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Lab2_b2.class);
                startActivity(intent);
            }
        });
        btnB3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Lab2_b3.class);
                startActivity(intent);
            }
        });
        btnB4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Lab2B4Activity.class);
                startActivity(intent);
            }
        });
    }
}