package com.example.dangdinhtien_ps10163_lab3;

import retrofit2.Call;
import retrofit2.http.GET;

public interface  ApiService  {
    @GET("/json_data.json")
    Call<ContactList> getMyJSON();
}
