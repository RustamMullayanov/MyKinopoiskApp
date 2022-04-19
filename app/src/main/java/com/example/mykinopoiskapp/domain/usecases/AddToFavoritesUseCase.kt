package com.example.mykinopoiskapp.domain.usecases

import com.example.mykinopoiskapp.domain.entities.Movie
import com.example.mykinopoiskapp.domain.repositories_interface.MovieRepository

class AddToFavoritesUseCase(private val movieRepository: MovieRepository) {
    operator fun invoke(movie: Movie): Boolean {
        return movieRepository.addToFavorites(movie)
    }
}