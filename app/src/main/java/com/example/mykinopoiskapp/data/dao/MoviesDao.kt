package com.example.mykinopoiskapp.data.dao

import androidx.room.*
import com.example.mykinopoiskapp.data.entities.MovieEntityForDB
import com.example.mykinopoiskapp.data.entities.MovieEntityForDB.Companion.TABLE_NAME
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface MoviesDao {

    @Query("SELECT * FROM $TABLE_NAME WHERE id = :id ")
    fun getCachedMovieById(id: Int): Single<MovieEntityForDB>

    @Query("SELECT * FROM $TABLE_NAME")
    fun getCachedMovies(): Single<List<MovieEntityForDB>>

    @Insert(entity = MovieEntityForDB::class, onConflict = OnConflictStrategy.REPLACE)
    fun cachedMovie(movie: MovieEntityForDB): Completable

    @Delete(entity = MovieEntityForDB::class)
    fun clearMovieCache(movie: MovieEntityForDB): Completable
}