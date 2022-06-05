package com.example.mykinopoiskapp.data.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.mykinopoiskapp.data.dao.typeConverters.ActorsConverters
import com.example.mykinopoiskapp.data.entities.MovieEntityForDB

@Database(
    entities = [MovieEntityForDB::class],
    version = 1
)
@TypeConverters(value = [ActorsConverters::class])
abstract class AppDatabase : RoomDatabase() {

    abstract fun moviesDao(): MoviesDao
}