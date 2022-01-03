package com.hfad.translator.view.main

import com.hfad.translator.di.NAME_LOCAL
import com.hfad.translator.di.NAME_REMOTE
import com.hfad.translator.model.data.AppState
import com.hfad.translator.model.data.DataModel
import com.hfad.translator.model.repository.Repository
import com.hfad.translator.viewmodel.Interactor
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject
import javax.inject.Named

/**
 * Снабжаем интерактор репозиторием для получения локальных или внешних данных
 */
class MainInteractor(
    private val repositoryRemote: Repository<List<DataModel>>,
    private val repositoryLocal: Repository<List<DataModel>>
) : Interactor<AppState> {

    override fun getData(word: String, fromRemoteSource: Boolean): Observable<AppState> {
        return if (fromRemoteSource) {
            repositoryRemote
        } else {
            repositoryLocal
        }.getData(word).map { AppState.Success(it) }
    }
}
