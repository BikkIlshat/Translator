package com.hfad.translator.di

import com.hfad.translator.view.history.HistoryInteractor
import com.hfad.translator.view.history.HistoryViewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val historyScreen = module {
    factory { HistoryViewModel(interactor = get()) }

    factory {
        HistoryInteractor(
            repositoryRemote = get(named(NAME_REMOTE)),
            repositoryLocal = get(named(NAME_LOCAL))) }
}
