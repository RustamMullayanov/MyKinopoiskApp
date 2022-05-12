package com.example.mykinopoiskapp.di

import com.example.mykinopoiskapp.di.module.RepositoryModule
import com.example.mykinopoiskapp.di.module.RetrofitModule
import com.example.mykinopoiskapp.ui.movies.MovieActivity
import com.example.mykinopoiskapp.ui.movies.MoviesFragment
import dagger.Component
import javax.inject.Singleton

@Component(modules = [RepositoryModule::class, RetrofitModule::class])
@Singleton
interface AppComponent {
    //Fragments
    fun inject(fragment: MoviesFragment)

    //Activities
    fun inject(activity: MovieActivity)
}