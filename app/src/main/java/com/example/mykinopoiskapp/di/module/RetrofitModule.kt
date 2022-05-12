package com.example.mykinopoiskapp.di.module

import com.example.mykinopoiskapp.data.api.RetrofitProvider
import com.example.mykinopoiskapp.data.api.RetrofitServiceMovies
import dagger.Module
import dagger.Provides
import kotlinx.serialization.ExperimentalSerializationApi

@Module
class RetrofitModule {

    @ExperimentalSerializationApi
    @Provides
    fun provideRetrofitServiceMovies(retrofitProvider: RetrofitProvider): RetrofitServiceMovies {
        return retrofitProvider.retrofitServiceMovies
    }
}