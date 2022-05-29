package com.example.mykinopoiskapp.data.api

import com.example.mykinopoiskapp.BuildConfig
import com.example.mykinopoiskapp.data.entities.KinopoiskResponse
import com.example.mykinopoiskapp.data.entities.MovieEntityForApi
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RetrofitServiceMovies {

    // Запрос на получения самых просматриваемых фильмов 2021 года
    @GET("/movie?field=type&search=movie&field=year&search=2021&sortField=votes.imdb&sortType=-1${BuildConfig.MY_TOKEN}")
    fun getMoviesList(): Single<KinopoiskResponse>

    @GET("/movie?${BuildConfig.MY_TOKEN}&sortField=votes.imdb&sortType=-1&field=type&search=movie&field=name")
    fun getMoviesListByName(@Query("search") search: String): Single<KinopoiskResponse>

    @GET("/movie?${BuildConfig.MY_TOKEN}&field=id")
    fun getMovieById(@Query("search") id: Int): Single<MovieEntityForApi>
}
