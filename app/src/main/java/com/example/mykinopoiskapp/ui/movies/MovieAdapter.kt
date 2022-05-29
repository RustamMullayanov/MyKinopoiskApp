package com.example.mykinopoiskapp.ui.movies

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mykinopoiskapp.databinding.CardActorsBinding
import com.example.mykinopoiskapp.domain.entities.Actor

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.MovieHolder>() {
    private var actors: List<Actor> = emptyList()

    class MovieHolder(val viewBinging: CardActorsBinding) :
            RecyclerView.ViewHolder(viewBinging.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
        val binding = CardActorsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return actors.size
    }
}