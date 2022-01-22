package com.hfad.translator.view.main


import com.hfad.model.AppState
import com.hfad.model.DataModel
import com.hfad.repository.Repository
import com.hfad.repository.RepositoryLocal
import com.hfad.translator.viewmodel.Interactor

/**
 * Снабжаем интерактор репозиторием для получения локальных или внешних данных
 */

class MainInteractor(
    private val repositoryRemote: Repository<List<DataModel>>,
    private val repositoryLocal: RepositoryLocal<List<DataModel>>
) : Interactor<AppState> {
    override suspend fun getData(word: String, fromRemoteSource: Boolean):
            AppState {
        val appState: AppState
        if (fromRemoteSource) {
            appState = AppState.Success(repositoryRemote.getData(word))
            repositoryLocal.saveToDB(appState)
        } else {
            appState = AppState.Success(repositoryLocal.getData(word))
        }
        return appState
    }
}