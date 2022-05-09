package com.example.mykinopoiskapp.data.repositories

import com.example.mykinopoiskapp.R
import com.example.mykinopoiskapp.domain.entities.Movie
import com.example.mykinopoiskapp.domain.repositories_interface.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor() : MovieRepository {

    // Тестовые данные для проверки верстки
    private val movies: List<Movie> = listOf(
        Movie(
            11111,
            "Ford против Ferrari",
            8.2,
            "",
            2019,
            listOf("Кристиан Бэйл", "Мэтт Дэймон", "Катрина Балф"),
            listOf(" Джон Бернард", "Питер Чернин"),
            listOf("биография", "спорт"),
            listOf("США"),
            R.string.movie_test_description.toString()
        ),
        Movie(
            11111,
            "Ford против Ferrari",
            8.2,
            "",
            2019,
            listOf("Кристиан Бэйл", "Мэтт Дэймон", "Катрина Балф"),
            listOf(" Джон Бернард", "Питер Чернин"),
            listOf("биография", "спорт", "драма", "боевик"),
            listOf("США"),
            R.string.movie_test_description.toString()
        ),
        Movie(
            11111,
            "Ford против Ferrari",
            8.2,
            "",
            2019,
            listOf("Кристиан Бэйл", "Мэтт Дэймон", "Катрина Балф"),
            listOf(" Джон Бернард", "Питер Чернин"),
            listOf("биография", "спорт", "драма", "боевик"),
            listOf("США"),
            R.string.movie_test_description.toString()
        ),
        Movie(
            11111,
            "Ford против Ferrari",
            8.2,
            "",
            2019,
            listOf("Кристиан Бэйл", "Мэтт Дэймон", "Катрина Балф"),
            listOf(" Джон Бернард", "Питер Чернин"),
            listOf("биография", "спорт", "драма", "боевик"),
            listOf("США"),
            R.string.movie_test_description.toString()
        ),
        Movie(
            11111,
            "Ford против Ferrari",
            8.2,
            "",
            2019,
            listOf("Кристиан Бэйл", "Мэтт Дэймон", "Катрина Балф"),
            listOf(" Джон Бернард", "Питер Чернин"),
            listOf("биография", "спорт", "драма", "боевик"),
            listOf("США"),
            R.string.movie_test_description.toString()
        ),
        Movie(
            11111,
            "Ford против Ferrari",
            8.2,
            "",
            2019,
            listOf("Кристиан Бэйл", "Мэтт Дэймон", "Катрина Балф"),
            listOf(" Джон Бернард", "Питер Чернин"),
            listOf("биография", "спорт", "драма", "боевик"),
            listOf("США"),
            R.string.movie_test_description.toString()
        )
    )

    override fun getMoviesInfo(): List<Movie> {
        return movies
    }

    override fun getMovieInfoById(id: Int): Movie {
        TODO("Not yet implemented")
    }

    override fun addToFavorites(movie: Movie): Boolean {
        TODO("Not yet implemented")
    }
}