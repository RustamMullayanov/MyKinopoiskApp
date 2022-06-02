package com.example.mykinopoiskapp.domain.repositories_interface

import com.example.mykinopoiskapp.domain.entities.Movie
import io.reactivex.Completable
import io.reactivex.Single

interface MovieRepository {
    fun getMoviesInfo(): Single<List<Movie>>

    fun getMovieInfoById(id: Int): Single<Movie>

    fun getMoviesInfoByName(name: String): Single<List<Movie>>

    fun getFavoritesInfo(): Single<List<Movie>>

    fun getFavoritesInfoById(id: Int): Single<Movie>

    fun addToFavorites(movie: Movie): Completable

    fun removeFromFavorites(movie: Movie): Completable
}