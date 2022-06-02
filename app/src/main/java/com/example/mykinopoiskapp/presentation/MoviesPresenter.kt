package com.example.mykinopoiskapp.presentation

import com.example.mykinopoiskapp.base.BasePresenter
import com.example.mykinopoiskapp.domain.usecases.GetMoviesInfoUseCase
import com.example.mykinopoiskapp.domain.usecases.SearchMoviesByNameUseCase
import com.example.mykinopoiskapp.views.MoviesView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import moxy.InjectViewState
import timber.log.Timber
import javax.inject.Inject

@InjectViewState
class MoviesPresenter @Inject constructor(
    private val getMoviesInfo: GetMoviesInfoUseCase,
    private val searchMoviesByName: SearchMoviesByNameUseCase
) : BasePresenter<MoviesView>() {

    override fun onFirstViewAttach() {
        getMovies()
    }

    fun getMovies() {
        getMoviesInfo()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ movies ->
                viewState.showMoviesInfo(movies)
            }, { error ->
                viewState.showError("Данные недоступны, повторите попытку позже")
                Timber.e(error)
            }).disposeOnFinish()
    }

    fun searchMovies(name: String) {
        searchMoviesByName(name)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ movies ->
                viewState.showMoviesInfo(movies)
            }, { error ->
                viewState.showError("Некорректное название фильма")
                Timber.e(error)
            }).disposeOnFinish()
    }
}