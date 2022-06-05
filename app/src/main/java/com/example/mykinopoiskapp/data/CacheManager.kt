package com.example.mykinopoiskapp.data

import com.example.mykinopoiskapp.data.dao.MoviesDao
import io.reactivex.Single
import javax.inject.Inject

class CacheManager @Inject constructor( private val moviesDao: MoviesDao) {

    fun isMovieCached(id: Int): Single<Boolean>{
        return moviesDao.getCachedMovieById(id).toSingle()
            .map { it.id > 0 }
            .onErrorReturnItem(false)
    }
}