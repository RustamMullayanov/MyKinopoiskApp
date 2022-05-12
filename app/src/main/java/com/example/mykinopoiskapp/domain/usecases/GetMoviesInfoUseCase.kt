package com.example.mykinopoiskapp.domain.usecases

import com.example.mykinopoiskapp.domain.entities.Movie
import com.example.mykinopoiskapp.domain.repositories_interface.MovieRepository
import io.reactivex.Single
import javax.inject.Inject

class GetMoviesInfoUseCase @Inject constructor(private val movieRepository: MovieRepository) {
    operator fun invoke(): Single<List<Movie>> {
        return movieRepository.getMoviesInfo()
    }
}