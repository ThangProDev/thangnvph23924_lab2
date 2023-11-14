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

public class BackgroundTask_POST extends AsyncTask<String, Void, String> {
    String link;

    Context context;
    String strDai, strRong;
    TextView tvResult;
    ProgressDialog progressDialog;
    String strResult;

    public BackgroundTask_POST(Context context,String link, String strDai, String strRong, TextView tvResult) {
        this.context = context;
        this.strDai = strDai;
        this.link = link;
        this.strRong = strRong;
        this.tvResult = tvResult;
    }

    @Override
    protected String doInBackground(String... Strings) {
        try{
            URL url = new URL(link);
            String param = "chieurong="+ URLEncoder.encode(strRong, "utf-8") + "&chieudai=" +URLEncoder.encode(strDai, "utf-8");
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
            while ((line = bufferedReader.readLine()) != null){
                sb.append(line);
            }
            strResult= sb.toString();
        }catch (Exception ex){
            Log.e("Error HCNAsyncTask", "//= "+ex.toString() );
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
