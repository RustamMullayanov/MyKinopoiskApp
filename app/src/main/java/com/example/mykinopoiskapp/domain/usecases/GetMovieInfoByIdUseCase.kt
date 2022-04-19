package com.example.mykinopoiskapp.domain.usecases

import com.example.mykinopoiskapp.domain.entities.Movie
import com.example.mykinopoiskapp.domain.repositories_interface.MovieRepository

class GetMovieInfoByIdUseCase(private val movieRepository: MovieRepository) {
    operator fun invoke(id: Int): Movie {
        return movieRepository.getMovieInfoById(id)
    }
}