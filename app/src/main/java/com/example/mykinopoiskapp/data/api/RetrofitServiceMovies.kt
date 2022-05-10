package com.example.mykinopoiskapp.data.api

import com.example.mykinopoiskapp.BuildConfig
import com.example.mykinopoiskapp.data.entities.KinopoiskResponse
import io.reactivex.Single
import retrofit2.http.GET

interface RetrofitServiceMovies {

    // Запрос на получения фильмов 2010 года с рейтингом от 5 до 10
    @GET("/movie?field=type&search=movie&field=year&search=2010&field=rating.kp&search=5-10${BuildConfig.MY_TOKEN}")
    fun getMoviesList(): Single<KinopoiskResponse>
}
