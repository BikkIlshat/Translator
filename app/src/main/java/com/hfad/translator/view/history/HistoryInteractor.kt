package com.hfad.translator.view.history

import com.hfad.translator.model.data.AppState
import com.hfad.translator.model.data.DataModel
import com.hfad.translator.model.repository.Repository
import com.hfad.translator.model.repository.RepositoryLocal
import com.hfad.translator.viewmodel.Interactor

class HistoryInteractor(
    private val repositoryRemote: Repository<List<DataModel>>,
    private val repositoryLocal: RepositoryLocal<List<DataModel>>
) : Interactor<AppState> {
    override suspend fun getData(word: String, fromRemoteSource: Boolean):
            AppState{
        return AppState.Success(
            if (fromRemoteSource) {
                repositoryRemote
            } else {
                repositoryLocal
            }.getData(word)
        )
    }
}