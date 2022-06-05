package com.example.mykinopoiskapp.data.repositories

import com.example.mykinopoiskapp.data.CacheManager
import com.example.mykinopoiskapp.data.api.RetrofitServiceMovies
import com.example.mykinopoiskapp.data.dao.MoviesDao
import com.example.mykinopoiskapp.data.dto.toDB
import com.example.mykinopoiskapp.data.dto.toDomain
import com.example.mykinopoiskapp.domain.entities.Movie
import com.example.mykinopoiskapp.domain.repositories_interface.MovieRepository
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val retrofitServiceMovies: RetrofitServiceMovies,
    private val moviesDao: MoviesDao,
    private val cacheManager: CacheManager
) : MovieRepository {

    override fun getMoviesInfo(): Single<List<Movie>> {
        return retrofitServiceMovies.getMoviesList().map { response ->
            response.movies.map { movie -> movie.toDomain() }
        }
    }

    override fun getMoviesInfoByName(name: String): Single<List<Movie>> {
        return retrofitServiceMovies.getMoviesListByName(name).map { response ->
            response.movies.map { movie -> movie.toDomain() }
        }
    }

    override fun getFavoritesInfo(): Single<List<Movie>> {
        return moviesDao.getCachedMovies().map { cache -> cache.map { it.toDomain() } }
    }

    override fun getMovieInfoById(id: Int): Single<Pair<Movie, Boolean>> {
        return cacheManager.isMovieCached(id)
            .flatMap { isCached ->
                if (isCached)
                    getMovieByIdFromCache(id, isCached)
                else
                    getMovieByIdFromServer(id, isCached)
            }
    }

    override fun addToFavorites(movie: Movie): Completable {
        return moviesDao.cachedMovie(movie.toDB())
    }

    override fun removeFromFavorites(movie: Movie): Completable {
        return moviesDao.clearMovieCache(movie.toDB())
    }

    private fun getMovieByIdFromServer(id: Int, isCached: Boolean): Single<Pair<Movie, Boolean>> {
        return retrofitServiceMovies.getMovieById(id)
            .flatMap { movie -> Single.just(movie.toDomain() to isCached) }
    }

    private fun getMovieByIdFromCache(id: Int, isCached: Boolean): Single<Pair<Movie, Boolean>> {
        return moviesDao.getCachedMovieById(id).toSingle()
            .flatMap { movie -> Single.just(movie.toDomain() to isCached) }
    }
}