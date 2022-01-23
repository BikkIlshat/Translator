package com.hfad.repository

import com.hfad.model.AppState
import com.hfad.model.DataModel


/**
 * Репозиторий возвращает данные, используя dataSource (локальный или внешний)
 */
class RepositoryImplLocal(private val dataSource:
                                    DataSourceLocal<List<DataModel>>) :
    RepositoryLocal<List<DataModel>> {
    override suspend fun getData(word: String): List<DataModel> {
        return dataSource.getData(word)
    }
    override suspend fun saveToDB(appState: AppState) {
        dataSource.saveToDB(appState)
    }
}
//