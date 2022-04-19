package com.example.mykinopoiskapp.di

import com.example.mykinopoiskapp.di.module.RepositoryModule
import com.example.mykinopoiskapp.ui.movies.MoviesFragment
import dagger.Component
import javax.inject.Singleton

@Component(modules = [RepositoryModule::class])
@Singleton
interface AppComponent {
    //Fragments
    fun inject(fragment: MoviesFragment)
}