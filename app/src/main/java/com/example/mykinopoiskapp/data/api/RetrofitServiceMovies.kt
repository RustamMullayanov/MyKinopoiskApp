package com.example.mykinopoiskapp.data.api

import com.example.mykinopoiskapp.BuildConfig
import com.example.mykinopoiskapp.data.entities.KinopoiskResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RetrofitServiceMovies {

    // Запрос на получения фильмов 2010 года с рейтингом от 5 до 10
    @GET("/movie?field=type&search=movie&field=year&search=2010&field=rating.kp&search=5-10${BuildConfig.MY_TOKEN}")
    fun getMoviesList(): Single<KinopoiskResponse>

    @GET("/movie?${BuildConfig.MY_TOKEN}&field=type&search=movie&field=name")
    fun getMoviesListByName(@Query("search") search: String): Single<KinopoiskResponse>

    @GET("/movie?field=type&search=movie&field=id&search={id}${BuildConfig.MY_TOKEN}")
    fun getMovieById(@Query("id") id: Int): Single<KinopoiskResponse>
}
