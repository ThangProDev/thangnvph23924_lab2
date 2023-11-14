



package com.example.thangnvph23924_lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Lab2_b2 extends AppCompatActivity {
    String link;
    EditText edtDai,edtRong;
    TextView tvResult;
    Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab2_b2);


        edtRong = findViewById(R.id.edtRong);
        edtDai = findViewById(R.id.edtDai);
        btnSend = findViewById(R.id.btnSend);
        tvResult = findViewById(R.id.tvResult);
        link = "http://192.168.43.241:80/my-web/rectangle_POST.php";

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BackgroundTask_POST backgroundTaskPost = new BackgroundTask_POST(Lab2_b2.this  ,link, edtDai.getText().toString(), edtRong.getText().toString(), tvResult);
                backgroundTaskPost.execute();
            }
        });
    }
}