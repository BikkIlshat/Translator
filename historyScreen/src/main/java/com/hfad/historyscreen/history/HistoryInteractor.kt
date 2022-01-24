package com.hfad.historyscreen.history


import com.hfad.core.viewmodel.Interactor
import com.hfad.model.data.AppState
import com.hfad.model.data.dto.SearchResultDto
import com.hfad.model.data.mapSearchResultToResult
import com.hfad.model.data.userdata.DataModel
import com.hfad.repository.Repository
import com.hfad.repository.RepositoryLocal

class HistoryInteractor(
    private val repositoryRemote: Repository<List<SearchResultDto>>,
    private val repositoryLocal: RepositoryLocal<List<SearchResultDto>>
) : Interactor<AppState> {

    override suspend fun getData(word: String, fromRemoteSource: Boolean): AppState {
        return AppState.Success(
            mapSearchResultToResult(
                if (fromRemoteSource) {
                    repositoryRemote
                } else {
                    repositoryLocal
                }.getData(word)
            )
        )
    }
}
