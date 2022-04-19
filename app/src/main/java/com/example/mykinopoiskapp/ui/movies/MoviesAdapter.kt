package com.example.mykinopoiskapp.ui.movies

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mykinopoiskapp.databinding.CardMovieBinding
import com.example.mykinopoiskapp.domain.entities.Movie

class MoviesAdapter : RecyclerView.Adapter<MoviesAdapter.MoviesHolder>() {
    private var movies: List<Movie> = emptyList()

    class MoviesHolder(val viewBinding: CardMovieBinding) :
        RecyclerView.ViewHolder(viewBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesHolder {
        val binding = CardMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MoviesHolder(binding)
    }

    override fun onBindViewHolder(holder: MoviesHolder, position: Int) {
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