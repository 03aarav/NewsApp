package com.example.newapp.Model

data class MyNewsData(
    val articles: List<Article?>?,
    val status: String?,
    val totalResults: Int?
)