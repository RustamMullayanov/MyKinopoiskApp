package com.example.mykinopoiskapp.presentation

import com.example.mykinopoiskapp.base.BasePresenter
import com.example.mykinopoiskapp.domain.entities.Movie
import com.example.mykinopoiskapp.domain.usecases.AddToFavoritesUseCase
import com.example.mykinopoiskapp.domain.usecases.GetMovieInfoByIdUseCase
import com.example.mykinopoiskapp.views.MovieView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import moxy.InjectViewState
import timber.log.Timber
import javax.inject.Inject

@InjectViewState
class MoviePresenter @Inject constructor(
    private val getMovieInfoById: GetMovieInfoByIdUseCase,
    private val addToFavoritesUseCase: AddToFavoritesUseCase
) : BasePresenter<MovieView>() {

    fun onAppearing(id: Int) {
        getMovieInfoById(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ movie ->
                viewState.showMovieInfo(movie)
                viewState.showActorsInfo(movie.actors)
            }, { error ->
                viewState.showError("Данные недоступны, повторите попытку позже")
                Timber.e(error)
            }).disposeOnFinish()
    }

    fun addToFavorites(movie: Movie) {
        addToFavoritesUseCase(movie)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                viewState.showError("Успешно добавленно в избранное")
            }, { error ->
                viewState.showError("Данные недоступны, повторите попытку позже")
                Timber.e(error)
            }).disposeOnFinish()
    }
}