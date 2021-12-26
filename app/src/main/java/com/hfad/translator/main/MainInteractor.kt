package com.hfad.translator.main

import com.hfad.translator.data.AppState
import com.hfad.translator.data.DataModel
import com.hfad.translator.presenter.Interactor
import com.hfad.translator.repository.Repository
import io.reactivex.rxjava3.core.Observable

/**
 * Снабжаем интерактор репозиторием для получения локальных или внешних данных
 */
class MainInteractor(
    private val remoteRepository: Repository<List<DataModel>>,
    private val localRepository: Repository<List<DataModel>>

) : Interactor<AppState> {

    override fun getData(word: String, fromRemoteSource: Boolean): Observable<AppState> {
        return if (fromRemoteSource) {
            remoteRepository
                .getData(word)
                .map { AppState.Success(it) }
        } else {
            localRepository
                .getData(word)
                .map { AppState.Success(it) }
        }
    }
}