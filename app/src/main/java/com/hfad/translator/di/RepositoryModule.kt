package com.hfad.translator.di

import androidx.room.Room
import com.hfad.translator.model.data.DataModel
import com.hfad.translator.model.datasource.RetrofitImpl
import com.hfad.translator.model.datasource.RoomDataBaseImpl
import com.hfad.translator.model.repository.Repository
import com.hfad.translator.model.repository.RepositoryImpl
import com.hfad.translator.model.repository.RepositoryImplLocal
import com.hfad.translator.model.repository.RepositoryLocal
import com.hfad.translator.room.HistoryDataBase
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