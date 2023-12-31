package com.example.thangnvph23924_lab2;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class StudentAsyncTask extends AsyncTask<String, Void, String> {
    private Context context;
    private String link, name, score, strResult;

    private TextView tvResult;

    public StudentAsyncTask(Context context, String link, String name, String score, TextView tvResult) {
        this.context = context;
        this.link = link;
        this.name = name;
        this.score = score;
        this.tvResult = tvResult;
    }

    @Override
    protected String doInBackground(String... strings) {
        link += "?name="+name+"&score="+score;
        try {
            URL url = new URL(link);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            StringBuffer sb = new StringBuffer();
            String line = "";
            while ((line = bufferedReader.readLine()) != null){
                sb.append(line);
            }
            strResult = sb.toString();
            urlConnection.disconnect();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        tvResult.setText(strResult);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }
}
