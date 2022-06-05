package com.example.mykinopoiskapp.di

import android.content.Context
import com.example.mykinopoiskapp.di.module.RepositoryModule
import com.example.mykinopoiskapp.di.module.RetrofitModule
import com.example.mykinopoiskapp.di.module.RoomModule
import com.example.mykinopoiskapp.ui.favorites.FavoritesFragment
import com.example.mykinopoiskapp.ui.movies.MovieActivity
import com.example.mykinopoiskapp.ui.movies.MoviesFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Component(modules = [RepositoryModule::class, RetrofitModule::class, RoomModule::class])
@Singleton
interface AppComponent {
    //Fragments
    fun inject(fragment: MoviesFragment)
    fun inject(fragment: FavoritesFragment)

    //Activities
    fun inject(activity: MovieActivity)

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }
}