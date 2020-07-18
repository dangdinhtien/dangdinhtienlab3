package com.example.dangdinhtien_ps10163_lab3;

import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class httpHandler{
    private static final String TAG = httpHandler.class.getSimpleName();

    public httpHandler(){

    }
    public String makeServiceCall(String reqUrl){
        String response = null;
        try{
            URL url = new URL(reqUrl);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            InputStream inputStream = new BufferedInputStream(con.getInputStream());
            response = convertStreamToString(inputStream);
        }catch (Exception e){
            e.printStackTrace();
            Log.e(TAG, "Exception: " + e.getMessage());
        }
        return response;
    }
    private String convertStreamToString(InputStream is) {
        BufferedReader read = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String line;
        try {
            while ((line = read.readLine()) != null) {
                sb.append(line).append("\n");
            }         } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return sb.toString();
    }
}
