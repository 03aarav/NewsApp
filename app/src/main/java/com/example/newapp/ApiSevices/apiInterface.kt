package com.example.newapp.ApiSevices

import com.example.newapp.Model.MyNewsData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

const val api_key="f57759b7446b4c018ffdeb579966018d"
interface apiInterface {
    @GET("v2/top-headlines?apiKey=$api_key")
    fun getNews(@Query("country") country:String,@Query("category") category: String,@Query("page")page:Int): Call<MyNewsData>
}