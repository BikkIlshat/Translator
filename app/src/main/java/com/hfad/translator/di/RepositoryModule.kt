package com.hfad.translator.di

import androidx.room.Room
import com.hfad.model.DataModel
import com.hfad.repository.*

import com.hfad.repository.room.HistoryDataBase
import org.koin.core.qualifier.named
import org.koin.dsl.module


val repositoryModule = module {
    single { Room.databaseBuilder(get(), HistoryDataBase::class.java, "HistoryDB").build() }
    single { get<HistoryDataBase>().historyDao() }

    single<Repository<List<DataModel>>>(named(NAME_REMOTE)) {
        RepositoryImpl(RetrofitImpl(apiService = get()))
    }

    single<RepositoryLocal<List<DataModel>>>(named(NAME_LOCAL)) {
        RepositoryImplLocal(RoomDataBaseImpl(historyDao = get()))
    }

}