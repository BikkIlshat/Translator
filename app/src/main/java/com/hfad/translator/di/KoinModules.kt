package com.hfad.translator.di

import com.hfad.translator.model.data.DataModel
import com.hfad.translator.model.datasource.RetrofitImpl
import com.hfad.translator.model.datasource.RoomDataBaseImpl
import com.hfad.translator.model.repository.Repository
import com.hfad.translator.model.repository.RepositoryImpl
import com.hfad.translator.view.main.MainInteractor
import com.hfad.translator.view.main.MainViewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module


val application = module {

    single<Repository<List<DataModel>>>(named(NAME_REMOTE)) {
        RepositoryImpl(RetrofitImpl()) }
    single<Repository<List<DataModel>>>(named(NAME_LOCAL)) {
        RepositoryImpl(RoomDataBaseImpl()) }
}

val mainScreen = module {
    factory { MainInteractor(get(named(NAME_REMOTE)), get(named(NAME_LOCAL))) }
    factory { MainViewModel(get()) }
}