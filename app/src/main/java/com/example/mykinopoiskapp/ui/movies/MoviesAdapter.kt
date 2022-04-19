package com.example.mykinopoiskapp.ui.movies

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mykinopoiskapp.databinding.CardMovieBinding

class MoviesAdapter : RecyclerView.Adapter<MoviesAdapter.MoviesHolder>() {

    class MoviesHolder(val viewBinding: CardMovieBinding) :
        RecyclerView.ViewHolder(viewBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesAdapter.MoviesHolder {
        val binding = CardMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MoviesHolder(binding)
    }

    override fun onBindViewHolder(holder: MoviesAdapter.MoviesHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}