package com.hfad.translator.di

import com.hfad.historyscreen.history.HistoryActivity
import com.hfad.historyscreen.history.HistoryInteractor
import com.hfad.historyscreen.history.HistoryViewModel
import org.koin.androidx.viewmodel.dsl.viewModel

import org.koin.core.qualifier.named
import org.koin.dsl.module


val historyScreen = module {
    scope(named<HistoryActivity>()) {
        scoped {
            HistoryInteractor(
                repositoryRemote = get(named(NAME_REMOTE)),
                repositoryLocal = get(named(NAME_LOCAL))
            )
        }
        viewModel { HistoryViewModel(interactor = get()) }
    }
}