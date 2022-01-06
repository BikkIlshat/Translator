package com.hfad.translator.di

import com.hfad.translator.view.main.MainInteractor
import org.koin.core.qualifier.named
import org.koin.dsl.module

val mainScreenModule = module {
    factory {
        MainInteractor(
            repositoryRemote = get(named(NAME_REMOTE)),
            repositoryLocal = get(named(NAME_LOCAL))
        )
    }
}
