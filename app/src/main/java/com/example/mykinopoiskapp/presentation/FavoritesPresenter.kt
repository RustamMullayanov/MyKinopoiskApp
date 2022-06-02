package com.example.mykinopoiskapp.presentation

import com.example.mykinopoiskapp.base.BasePresenter
import com.example.mykinopoiskapp.domain.usecases.GetFavoritesInfoUseCase
import com.example.mykinopoiskapp.views.FavoritesView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import moxy.InjectViewState
import timber.log.Timber
import javax.inject.Inject

@InjectViewState
class FavoritesPresenter @Inject constructor(
    private val getFavoritesInfoUseCase: GetFavoritesInfoUseCase
) : BasePresenter<FavoritesView>() {

    override fun onFirstViewAttach() {
        getFavorites()
    }

    private fun getFavorites() {
        getFavoritesInfoUseCase()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ movies ->
                viewState.showFavoritesInfo(movies)
            }, { error ->
                viewState.showError("Данные недоступны, повторите попытку позже")
                Timber.e(error)
            }).disposeOnFinish()
    }
}