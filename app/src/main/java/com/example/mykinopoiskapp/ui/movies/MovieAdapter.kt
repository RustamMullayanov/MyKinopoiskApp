package com.example.mykinopoiskapp.ui.movies

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.mykinopoiskapp.R
import com.example.mykinopoiskapp.databinding.CardMovieBinding
import com.example.mykinopoiskapp.domain.entities.Movie

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.MovieHolder>() {
    private var movies: List<Movie> = emptyList()

    class MovieHolder(val viewBinding: CardMovieBinding) :
        RecyclerView.ViewHolder(viewBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
        val binding = CardMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        val item = movies[position]
        with(holder.viewBinding) {

            movieFieldName.text = item.title
            movieFieldYear.text = item.year.toString()
            movieFieldRating.text = item.rating.toString()
            movieFieldRating.setBackgroundColor(
                setRatingColor(
                    item.rating,
                    movieFieldRating.context
                )
            )
            //Хардкод, надо добавить в верстку поле для минут
            movieFieldLength.text = "${item.movieLength} мин."
            // Хардкодный постер для теста верстки
            moviePoster.setImageResource(R.drawable.movie_poster)
        }
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    private fun setRatingColor(rating: Double, context: Context): Int {
        if (rating >= 9)
            return ContextCompat.getColor(context, R.color.rating_excellent)
        if (rating >= 7)
            return ContextCompat.getColor(context, R.color.rating_very_good)
        if (rating >= 6)
            return ContextCompat.getColor(context, R.color.rating_good)
        return ContextCompat.getColor(context, R.color.rating_bad)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setMovies(movies: List<Movie>) {
        this.movies = movies
        notifyDataSetChanged()
    }
}