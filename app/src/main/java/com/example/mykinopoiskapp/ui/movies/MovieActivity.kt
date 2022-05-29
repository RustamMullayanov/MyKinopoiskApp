package com.example.mykinopoiskapp.ui.movies

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.mykinopoiskapp.App
import com.example.mykinopoiskapp.databinding.ActivityMovieBinding
import com.example.mykinopoiskapp.domain.entities.Actor
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
    private lateinit var actorAdapter: ActorAdapter

    private val movieId: Int by lazy { intent.getIntExtra(EXTRA_MOVIE_ID, 0) }

    override fun onCreate(savedInstanceState: Bundle?) {
        App.appComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        actorAdapter = ActorAdapter()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.recycleActors.apply {
            layoutManager = LinearLayoutManager(
                this.context,
                LinearLayoutManager.HORIZONTAL,
                false
            )
            adapter = actorAdapter
        }

        moviePresenter.onAppearing(movieId)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                this.finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun showMovieInfo(movie: Movie) {
        with(binding) {
            movieName.text = movie.title
            movieRating.text = movie.rating.toString()
            movieLength.text = movie.movieLength.toString()
            movieFiledDescription.text = movie.description
            movieFiledDescription.setOnClickListener { view ->
                (view as TextView).maxLines = Int.MAX_VALUE
            }
            movieYear.text = movie.year.toString()

            Glide
                .with(moviePoster.context)
                .load(movie.posterUrl)
                .into(moviePoster)
        }

        supportActionBar?.title = movie.title
    }

    override fun showActorsInfo(actors: List<Actor>) {
        actorAdapter.setActors(actors)
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