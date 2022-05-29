package com.example.mykinopoiskapp.ui.movies

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mykinopoiskapp.databinding.CardActorsBinding
import com.example.mykinopoiskapp.domain.entities.Actor

class ActorAdapter : RecyclerView.Adapter<ActorAdapter.ActorHolder>() {
    private var actors: List<Actor> = emptyList()

    class ActorHolder(val viewBinging: CardActorsBinding) :
        RecyclerView.ViewHolder(viewBinging.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActorHolder {
        val binding = CardActorsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ActorHolder(binding)
    }

    override fun onBindViewHolder(holder: ActorHolder, position: Int) {
        val item = actors[position]
        with(holder.viewBinging) {
            actorName.text = item.name

            Glide
                .with(actorPhoto.context)
                .load(item.photo)
                .into(actorPhoto)
        }
    }

    override fun getItemCount(): Int {
        return actors.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setActors(actors: List<Actor>) {
        this.actors = actors
        notifyDataSetChanged()
    }
}