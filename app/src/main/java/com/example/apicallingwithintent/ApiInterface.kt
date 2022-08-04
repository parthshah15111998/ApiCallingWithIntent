package com.example.apicallingwithintent

import com.example.apicallingwithintent.model.MovieClassItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("movielist.json")
    fun getMovieList():Call<List<MovieClassItem>>
}