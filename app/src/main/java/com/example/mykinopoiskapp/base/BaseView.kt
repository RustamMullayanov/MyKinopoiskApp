package com.example.mykinopoiskapp.base

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(value = AddToEndSingleStrategy::class)
interface BaseView : MvpView{
    fun showSuccess(message: String)
    fun showError(error: String)
}