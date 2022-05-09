package com.example.mykinopoiskapp.di.module

import com.example.mykinopoiskapp.data.repositories.MovieRepositoryImpl
import com.example.mykinopoiskapp.domain.repositories_interface.MovieRepository
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryModule {
    @Binds
    abstract fun provideMovieRepository(movieRepositoryImpl: MovieRepositoryImpl):
            MovieRepository
}