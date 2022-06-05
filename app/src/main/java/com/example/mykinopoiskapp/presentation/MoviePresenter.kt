package com.example.mykinopoiskapp.presentation

import com.example.mykinopoiskapp.base.BasePresenter
import com.example.mykinopoiskapp.domain.entities.Movie
import com.example.mykinopoiskapp.domain.usecases.AddToFavoritesUseCase
import com.example.mykinopoiskapp.domain.usecases.GetMovieInfoByIdUseCase
import com.example.mykinopoiskapp.domain.usecases.RemoveFromFavoritesUseCase
import com.example.mykinopoiskapp.views.MovieView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import moxy.InjectViewState
import timber.log.Timber
import javax.inject.Inject

@InjectViewState
class MoviePresenter @Inject constructor(
    private val getMovieInfoById: GetMovieInfoByIdUseCase,
    private val addToFavoritesUseCase: AddToFavoritesUseCase,
    private val removeFromFavoritesUseCase: RemoveFromFavoritesUseCase
) : BasePresenter<MovieView>() {

    fun onAppearing(id: Int) {
        getMovieInfoById(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ (movie, isCached) ->
                viewState.showMovieInfo(movie)
                viewState.showActorsInfo(movie.actors)
                if(isCached)
                    viewState.showButtonRemoveFromCache()
                else
                    viewState.showButtonAddToCache()
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
                viewState.showError("Фильм добавлен в избранное")
                viewState.showButtonRemoveFromCache()
            }, { error ->
                viewState.showError("Ошибка, повторите попытку позже")
                Timber.e(error)
            }).disposeOnFinish()
    }

    fun removeFromFavorites(movie: Movie){
        removeFromFavoritesUseCase(movie)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                viewState.showError("Фильм удален из избранного")
                viewState.showButtonAddToCache()
            }, { error ->
                viewState.showError("Ошибка, повторите попытку позже")
                Timber.e(error)
            }).disposeOnFinish()
    }
}