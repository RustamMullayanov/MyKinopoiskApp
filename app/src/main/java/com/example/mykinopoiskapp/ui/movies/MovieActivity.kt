package com.example.mykinopoiskapp.ui.movies

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.example.mykinopoiskapp.App
import com.example.mykinopoiskapp.databinding.ActivityMovieBinding
import com.example.mykinopoiskapp.domain.entities.Movie
import com.example.mykinopoiskapp.presentation.MoviePresenter
import com.example.mykinopoiskapp.views.MovieView
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter
import javax.inject.Inject
import javax.inject.Provider

class MovieActivity : MvpAppCompatActivity(), MovieView {

    @Inject
    lateinit var presenterProvider: Provider<MoviePresenter>

    private val moviePresenter by moxyPresenter { presenterProvider.get() }

    private val binding: ActivityMovieBinding by lazy {
        ActivityMovieBinding.inflate(layoutInflater)
    }

    private val movieId: Int by lazy { intent.getIntExtra(EXTRA_MOVIE_ID, 0) }

    override fun onCreate(savedInstanceState: Bundle?) {
        App.appComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        moviePresenter.onAppearing(movieId)
    }

    override fun showMovieInfo(movie: Movie) {
        TODO("Not yet implemented")
    }

    override fun showSuccess(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun showError(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
    }

    companion object {

        private const val EXTRA_MOVIE_ID = "extra_movie_id"

        fun createIntent(context: Context, movieId: Int): Intent {
            return Intent(context, MovieActivity::class.java).apply {
                putExtra(EXTRA_MOVIE_ID, movieId)
            }
        }
    }
}