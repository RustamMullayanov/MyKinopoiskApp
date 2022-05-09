package com.example.mykinopoiskapp.views

import com.example.mykinopoiskapp.base.BaseView
import com.example.mykinopoiskapp.domain.entities.Movie
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(value = AddToEndSingleStrategy::class)
interface MoviesView : BaseView {
    fun showMoviesInfo(movies: List<Movie>)
}