package com.hfad.repository

import com.hfad.model.data.AppState
import com.hfad.model.data.dto.SearchResultDto


/**
 * Репозиторий возвращает данные, используя dataSource (локальный или внешний)
 */
class RepositoryImplLocal(
    private val dataSource:
    DataSourceLocal<List<SearchResultDto>>,
) :
    RepositoryLocal<List<SearchResultDto>> {
    override suspend fun getData(word: String): List<SearchResultDto> {
        return dataSource.getData(word)
    }

    override suspend fun saveToDB(appState: AppState) {
        dataSource.saveToDB(appState)
    }
}
//