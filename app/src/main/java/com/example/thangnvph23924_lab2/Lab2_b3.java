package com.example.thangnvph23924_lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Lab2_b3 extends AppCompatActivity {

    EditText edCanh;
    Button btnSend;
    String link;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab2_b3);

        edCanh = findViewById(R.id.edtCanh);
        btnSend = findViewById(R.id.btnSend);
        tvResult = findViewById(R.id.tvResult);
        link = "http://192.168.43.241:80/my-web/canh_POST.php";
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lab2b3 lab2B3 = new lab2b3(Lab2_b3.this  ,link, edCanh.getText().toString(), tvResult);
                lab2B3.execute();
            }
        });
    }
}