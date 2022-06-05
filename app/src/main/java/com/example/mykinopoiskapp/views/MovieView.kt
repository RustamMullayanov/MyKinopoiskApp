package com.example.mykinopoiskapp.views

import com.example.mykinopoiskapp.base.BaseView
import com.example.mykinopoiskapp.domain.entities.Actor
import com.example.mykinopoiskapp.domain.entities.Movie
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(value = AddToEndSingleStrategy::class)
interface MovieView: BaseView {
    fun showMovieInfo(movie: Movie)
    fun showActorsInfo(actors: List<Actor>)
    fun showButtonRemoveFromCache()
    fun showButtonAddToCache()
}