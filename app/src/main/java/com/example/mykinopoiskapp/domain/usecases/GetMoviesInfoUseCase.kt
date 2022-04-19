package com.example.mykinopoiskapp.domain.usecases

import com.example.mykinopoiskapp.domain.entities.Movie
import com.example.mykinopoiskapp.domain.repositories_interface.MovieRepository

class GetMoviesInfoUseCase(private val movieRepository: MovieRepository) {
    operator fun invoke(): List<Movie> {
        return movieRepository.getMoviesInfo()
    }
}