package com.example.mykinopoiskapp.domain.repositories_interface

import com.example.mykinopoiskapp.domain.entities.Movie

interface MovieRepository {
    fun getMoviesInfo(): List<Movie>

    fun getMovieInfoById(id: Int): Movie

    fun addToFavorites(movie: Movie): Boolean
}