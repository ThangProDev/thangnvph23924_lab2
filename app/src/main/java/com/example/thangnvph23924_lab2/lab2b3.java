package com.example.thangnvph23924_lab2;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class lab2b3 extends AsyncTask<String, Void, String> {
    String link;

    Context context;
    String strCanh;
    TextView tvResult;
    ProgressDialog progressDialog;
    String strResult;

    public lab2b3( Context context,String link, String strCanh, TextView tvResult) {
        this.link = link;
        this.context = context;
        this.strCanh = strCanh;
        this.tvResult = tvResult;
    }

    @Override
    protected String doInBackground(String... strings) {
        try {
            URL url = new URL(link);
            String param = "canh=" + URLEncoder.encode(strCanh, "utf-8");
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setDoOutput(true);
            urlConnection.setRequestMethod("POST");
            urlConnection.setFixedLengthStreamingMode(param.getBytes().length);
            urlConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            PrintWriter printWriter = new PrintWriter(urlConnection.getOutputStream());
            printWriter.print(param);
            printWriter.close();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            StringBuffer sb = new StringBuffer();
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line);
            }
            strResult = sb.toString();
        } catch (Exception ex) {
            Log.e("Error HCNAsyncTask", "//= " + ex.toString());
        }
        return null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        tvResult.setText(strResult);
    }
}
