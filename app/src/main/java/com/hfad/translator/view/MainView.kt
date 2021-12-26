package com.hfad.translator.view

import com.hfad.translator.data.AppState

/**
 * Нижний уровень. View знает о контексте и фреймворке
 */
interface MainView {
    fun renderData(appState: AppState)
}