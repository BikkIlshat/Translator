package com.hfad.translator.presenter

import com.hfad.translator.data.AppState
import com.hfad.translator.view.MainView

/**
 *  На уровень выше от MainView находится Presenter, который уже ничего не знает ни о контексте, ни
о фреймворке
 */
interface Presenter<T : AppState, V : MainView> {

    fun attachView(view: V)

    fun detachView(view: V)

    fun getData(word: String, isOnline: Boolean)

}