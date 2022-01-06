package com.hfad.translator.di

import com.hfad.translator.model.data.DataModel
import com.hfad.translator.model.datasource.RetrofitImpl
import com.hfad.translator.model.datasource.RoomDataBaseImpl
import com.hfad.translator.model.repository.Repository
import com.hfad.translator.model.repository.RepositoryImpl
import org.koin.core.qualifier.named
import org.koin.dsl.module


val repositoryModule = module {
    single<Repository<List<DataModel>>>(named(NAME_REMOTE)) {
        RepositoryImpl(RetrofitImpl(apiService = get()))
    }

    single<Repository<List<DataModel>>>(named(NAME_LOCAL)) {
        RepositoryImpl(RoomDataBaseImpl())
    }

}