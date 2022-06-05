package com.example.mykinopoiskapp.di

import android.content.Context
import androidx.room.Room
import com.example.mykinopoiskapp.BuildConfig
import com.example.mykinopoiskapp.data.dao.AppDatabase
import com.example.mykinopoiskapp.data.dao.MoviesDao
import javax.inject.Inject

class DaoProvider @Inject constructor(context: Context) {

    private val database = Room.databaseBuilder(
        context,
        AppDatabase::class.java,
        BuildConfig.DB_NAME
    ).build()

    val moviesDao: MoviesDao
        get() = database.moviesDao()
}