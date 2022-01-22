package com.hfad.historyscreen.history


import com.hfad.core.viewmodel.Interactor
import com.hfad.model.AppState
import com.hfad.model.DataModel
import com.hfad.repository.Repository
import com.hfad.repository.RepositoryLocal

class HistoryInteractor(
    private val repositoryRemote: Repository<List<DataModel>>,
    private val repositoryLocal: RepositoryLocal<List<DataModel>>,
) : Interactor<AppState> {
    override suspend fun getData(word: String, fromRemoteSource: Boolean):
            AppState {
        return AppState.Success(
            if (fromRemoteSource) {
                repositoryRemote
            } else {
                repositoryLocal
            }.getData(word)
        )
    }
}