package com.example.mykinopoiskapp.presentation

import android.util.Log
import com.example.mykinopoiskapp.base.BasePresenter
import com.example.mykinopoiskapp.domain.usecases.GetMovieInfoByIdUseCase
import com.example.mykinopoiskapp.views.MovieView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import moxy.InjectViewState
import timber.log.Timber
import javax.inject.Inject

@InjectViewState
class MoviePresenter @Inject constructor(
    private val getMovieInfoById: GetMovieInfoByIdUseCase
): BasePresenter<MovieView>() {

    fun onAppearing(id: Int){
        getMovieInfoById(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ movie ->
                viewState.showMovieInfo(movie)
            }, { error ->
                viewState.showError("Данные недоступны, повторите попытку позже")
                Timber.e(error)
                Log.e("TAG", error.toString())
            }).disposeOnFinish()
    }
}