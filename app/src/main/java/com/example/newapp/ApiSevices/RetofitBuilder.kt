package com.example.newapp.ApiSevices

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetofitBuilder {

    companion object{
        val base_url = "https://newsapi.org/"
        fun retofitbuilder():Retrofit{
            return Retrofit.Builder()
                .baseUrl(base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        }
    }
}