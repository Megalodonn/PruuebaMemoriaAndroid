package com.example.memoriaapi.interfaces;

import com.example.memoriaapi.models.Estados;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface EstadosAPI {
    @GET("api/Estados/{id}")
    public Call<Estados> find(@Path("id") String id);
    //public Call<Estados> find();
}
