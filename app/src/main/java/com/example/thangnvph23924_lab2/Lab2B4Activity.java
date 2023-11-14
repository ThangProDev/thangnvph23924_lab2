package com.example.thangnvph23924_lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Lab2B4Activity extends AppCompatActivity {

    EditText edtA, edtB, edtC;
    Button btnSend;
    TextView tvResult;
    String link;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab2_b4);

        edtA = findViewById(R.id.edtA);
        edtB = findViewById(R.id.edtB);
        edtC = findViewById(R.id.edtC);
        btnSend = findViewById(R.id.btnSend);
        tvResult = findViewById(R.id.tvResult);
        link = "http://192.168.43.241:80/my-web/giaPhuongTrinh.php";


        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                B4AsyncTask asyncTask = new B4AsyncTask(Lab2B4Activity.this, link, edtA.getText().toString(), edtB.getText().toString(), edtC.getText().toString(), tvResult);
                asyncTask.execute();
            }
        });
    }
}