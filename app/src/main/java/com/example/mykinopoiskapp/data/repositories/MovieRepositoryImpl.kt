package com.example.mykinopoiskapp.data.repositories

import com.example.mykinopoiskapp.R
import com.example.mykinopoiskapp.data.api.RetrofitServiceMovies
import com.example.mykinopoiskapp.data.dto.toDomain
import com.example.mykinopoiskapp.domain.entities.Movie
import com.example.mykinopoiskapp.domain.repositories_interface.MovieRepository
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val retrofitServiceMovies: RetrofitServiceMovies
) : MovieRepository {

    // Тестовые данные для проверки верстки
    private val movies: List<Movie> = listOf(
        Movie(
            11111,
            "Ford против Ferrari",
            8.2,
            "",
            2019,
            R.string.movie_test_description.toString()
        ),
        Movie(
            11111,
            "Ford против Ferrari",
            8.2,
            "",
            2019,
            R.string.movie_test_description.toString()
        ),
        Movie(
            11111,
            "Ford против Ferrari",
            8.2,
            "",
            2019,
            R.string.movie_test_description.toString()
        ),
        Movie(
            11111,
            "Ford против Ferrari",
            8.2,
            "",
            2019,
            R.string.movie_test_description.toString()
        ),
        Movie(
            11111,
            "Ford против Ferrari",
            8.2,
            "",
            2019,
            R.string.movie_test_description.toString()
        ),
        Movie(
            11111,
            "Ford против Ferrari",
            8.2,
            "",
            2019,
            R.string.movie_test_description.toString()
        )
    )

    override fun getMoviesInfo(): Single<List<Movie>> {
        return retrofitServiceMovies.getMoviesList().map { response ->
            response.movies.map { movie->movie.toDomain() }
        }
    }

    override fun getMovieInfoById(id: Int): Single<Movie> {
        TODO("Not yet implemented")
    }

    override fun addToFavorites(movie: Movie): Completable {
        TODO("Not yet implemented")
    }
}