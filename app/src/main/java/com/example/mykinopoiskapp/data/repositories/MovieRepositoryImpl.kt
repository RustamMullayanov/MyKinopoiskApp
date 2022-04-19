package com.example.mykinopoiskapp.data.repositories

import com.example.mykinopoiskapp.domain.entities.Movie
import com.example.mykinopoiskapp.domain.repositories_interface.MovieRepository

class MovieRepositoryImpl: MovieRepository {
    override fun getMoviesInfo(): List<Movie> {
        TODO("Not yet implemented")
    }

    override fun getMovieInfoById(id: Int): Movie {
        TODO("Not yet implemented")
    }

    override fun addToFavorites(movie: Movie): Boolean {
        TODO("Not yet implemented")
    }
}