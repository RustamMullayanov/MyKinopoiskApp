package com.example.mykinopoiskapp.domain.usecases

import com.example.mykinopoiskapp.domain.entities.Movie
import com.example.mykinopoiskapp.domain.repositories_interface.MovieRepository
import javax.inject.Inject

class GetMoviesInfoUseCase @Inject constructor(private val movieRepository: MovieRepository) {
    operator fun invoke(): List<Movie> {
        return movieRepository.getMoviesInfo()
    }
}