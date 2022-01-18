package com.hfad.translator.model.repository

import com.hfad.translator.model.data.AppState
import com.hfad.translator.model.data.DataModel
import com.hfad.translator.model.datasource.DataSource
import com.hfad.translator.model.datasource.DataSourceLocal


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