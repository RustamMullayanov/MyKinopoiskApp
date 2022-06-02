package com.example.mykinopoiskapp.data.repositories

import com.example.mykinopoiskapp.R
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
    private val moviesDao: MoviesDao
) : MovieRepository {

    // Тестовые данные для проверки верстки
    private val movies: List<Movie> = listOf(
    )

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

    override fun getFavoritesInfoById(id: Int): Single<Movie> {
        return moviesDao.getCachedMovieById(id).map { it.toDomain() }
    }

    override fun getMovieInfoById(id: Int): Single<Movie> {
        return retrofitServiceMovies.getMovieById(id).map { movie -> movie.toDomain() }
    }

    override fun addToFavorites(movie: Movie): Completable {
        return moviesDao.cachedMovie(movie.toDB())
    }

    override fun removeFromFavorites(movie: Movie): Completable {
        return moviesDao.clearMovieCache(movie.toDB())
    }
}