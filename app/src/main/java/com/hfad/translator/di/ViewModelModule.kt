package com.hfad.translator.di

import com.hfad.translator.view.main.MainViewModel
import org.koin.dsl.module

val viewModelModule = module {
factory { MainViewModel(interactor = get()) }
}