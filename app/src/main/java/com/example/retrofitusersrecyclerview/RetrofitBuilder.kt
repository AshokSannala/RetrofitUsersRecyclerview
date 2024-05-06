package com.example.retrofitusersrecyclerview

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {

    private lateinit var retrofit : Retrofit

    fun getRetrofit() : Retrofit {

        if (!this::retrofit.isInitialized){
            retrofit = Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        return retrofit
    }
}