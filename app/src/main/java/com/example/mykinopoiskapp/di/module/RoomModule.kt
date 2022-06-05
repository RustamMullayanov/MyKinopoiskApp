package com.example.mykinopoiskapp.di.module

import com.example.mykinopoiskapp.data.dao.MoviesDao
import com.example.mykinopoiskapp.di.DaoProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RoomModule {

    @Provides
    @Singleton
    fun provideMoviesDao(daoProvider: DaoProvider): MoviesDao {
        return daoProvider.moviesDao
    }
}