package com.example.retrofit2withmvvm.retrofit

import com.example.retrofit2withmvvm.model.CountryModel
import retrofit2.Call
import retrofit2.http.GET

interface RetroService {

    @GET("all")
    fun getCountryList() : Call<List<CountryModel>>



}