package com.example.dangdinhtien_ps10163_lab3;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ManActivity_bai3 extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<AndroidVersion> data;
    private DataAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_bai3);
        initViews();
    }

    private void initViews(){
        recyclerView = (RecyclerView)findViewById(R.id.card_recycler);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        loadJSON();
    }
        private void loadJSON(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.learn2crack.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RetrofitInterface request = retrofit.create(RetrofitInterface.class);
                Call<JSONResponse> call = request.getJSON();
                call.enqueue(new Callback<JSONResponse>() {
                    @Override
                    public void onResponse(Call<JSONResponse> call, Response<JSONResponse> response) {

        JSONResponse jsonResponse = response.body();
        data = new ArrayList<>(Arrays.asList(jsonResponse.getAndroid()));
        adapter = new DataAdapter(data);
        recyclerView.setAdapter(adapter);
                    }

        @Override
        public void onFailure(Call<JSONResponse> call, Throwable t) {
        Log.d("Error",t.getMessage());
    }
    });
    }
}