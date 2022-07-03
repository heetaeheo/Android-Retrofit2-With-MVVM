package com.example.retrofit2withmvvm.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetroInstance {


    companion object {
        val Base_Url  = "https://restcountries.com/v2/"//

        fun getRetroInstance() : Retrofit {
            return Retrofit.Builder()
                .baseUrl(Base_Url)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}