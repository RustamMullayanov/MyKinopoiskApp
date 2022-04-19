package com.example.mykinopoiskapp.presentation

import com.example.mykinopoiskapp.base.BasePresenter
import com.example.mykinopoiskapp.domain.usecases.GetMoviesInfoUseCase
import com.example.mykinopoiskapp.views.MoviesView
import moxy.InjectViewState
import javax.inject.Inject

@InjectViewState
class MoviesPresenter @Inject constructor(
    private val getMoviesInfo: GetMoviesInfoUseCase
) : BasePresenter<MoviesView>() {

    override fun onFirstViewAttach() {
        //getMovies()
    }

    private fun getMovies(){
        viewState.showMoviesInfo(getMoviesInfo())
        viewState.showSuccess("Данные успешно загрузились")
    }
}