package com.example.thangnvph23924_lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Lab2_b1 extends AppCompatActivity {
    TextView tvResult;
    EditText edName, edScore;
    Button btnSend;
    String link;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab2_b1);
        tvResult = (TextView) findViewById(R.id.tvResult);
        edName = (EditText) findViewById(R.id.edtName);
        edScore = (EditText) findViewById(R.id.edtScore);
        link = "http://192.168.43.241:80/my-web/student_GET.php";
        btnSend = findViewById(R.id.btnSend);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StudentAsyncTask asyncTask = new StudentAsyncTask(Lab2_b1.this, link, edName.getText().toString(), edScore.getText().toString(), tvResult);
                asyncTask.execute();

            }
        });
    }

}