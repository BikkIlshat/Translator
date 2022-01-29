package com.hfad.translator.view.main


import com.hfad.core.viewmodel.Interactor
import com.hfad.model.data.AppState
import com.hfad.model.data.dto.SearchResultDto
import com.hfad.repository.Repository
import com.hfad.repository.RepositoryLocal
import com.hfad.translator.utils.mapSearchResultToResult

/**
 * Снабжаем интерактор репозиторием для получения локальных или внешних данных
 */

class MainInteractor(
    private val repositoryRemote: Repository<List<SearchResultDto>>,
    private val repositoryLocal: RepositoryLocal<List<SearchResultDto>>,
) : Interactor<AppState> {

    override suspend fun getData(word: String, fromRemoteSource: Boolean): AppState {
        val appState: AppState
        if (fromRemoteSource) {
            appState = AppState.Success(mapSearchResultToResult(repositoryRemote.getData(word)))
            repositoryLocal.saveToDB(appState)
        } else {
            appState = AppState.Success(mapSearchResultToResult(repositoryLocal.getData(word)))
        }
        return appState
    }
}
