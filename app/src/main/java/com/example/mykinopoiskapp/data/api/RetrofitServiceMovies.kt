package com.example.mykinopoiskapp.data.api

import com.example.mykinopoiskapp.BuildConfig
import com.example.mykinopoiskapp.data.entities.MovieEntityForApi
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitServiceMovies {

    @GET("/movies/all/page/1${BuildConfig.MY_TOKEN}")
    fun getMoviesList(): Call<List<MovieEntityForApi>>
}
