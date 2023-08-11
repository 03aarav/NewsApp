package com.example.newapp.MyViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newapp.ApiSevices.RetofitBuilder
import com.example.newapp.ApiSevices.apiInterface
import com.example.newapp.Model.Article
import com.example.newapp.Model.MyNewsData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class MyViewModel1:ViewModel() {
    lateinit var retorfitBuilder:RetofitBuilder
    lateinit var apiInterface: apiInterface

    var NewsLiveData=MutableLiveData<List<Article>?>()

    fun RetofitData( country:String,category: String,page:Int){

        val retrofithttp=RetofitBuilder.
        retofitbuilder().create(com.example.newapp.ApiSevices.apiInterface::class.java)
        val retrofitData=retrofithttp.getNews(country, category,page)

        retrofitData.enqueue(object : Callback<MyNewsData> {
            override fun onResponse(call: Call<MyNewsData>, response: Response<MyNewsData>) {
                NewsLiveData.postValue(response.body()?.articles as List<Article>?)

            }

            override fun onFailure(call: Call<MyNewsData>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })






    }


}