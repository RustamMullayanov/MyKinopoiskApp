package com.example.mykinopoiskapp.ui.movies

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
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
            movieFieldGenres.text = item.genres.toString()
            movieFieldYear.text = item.year.toString()
        }
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setMovies(movies: List<Movie>) {
        this.movies = movies
        notifyDataSetChanged()
    }
}