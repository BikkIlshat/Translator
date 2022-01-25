package com.hfad.translator.di

import com.hfad.translator.view.main.MainActivity
import com.hfad.translator.view.main.MainInteractor
import com.hfad.translator.view.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module


val mainScreenModule = module {
    scope(named<MainActivity>()) {
        scoped {
            MainInteractor(
                repositoryRemote = get(named(NAME_REMOTE)),
                repositoryLocal = get(named(NAME_LOCAL)))
        }
        viewModel { MainViewModel(interactor = get()) }
    }
}
