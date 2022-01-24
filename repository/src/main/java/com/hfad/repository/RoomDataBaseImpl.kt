package com.hfad.repository

import com.hfad.model.data.AppState
import com.hfad.model.data.dto.SearchResultDto
import com.hfad.repository.room.HistoryDao


class RoomDataBaseImpl(private val historyDao: HistoryDao) :
    DataSourceLocal<List<SearchResultDto>> {

    override suspend fun getData(word: String): List<SearchResultDto> {
        return mapHistoryEntityToSearchResult(historyDao.all())
    }

    override suspend fun saveToDB(appState: AppState) {
        convertDataModelSuccessToEntity(appState)?.let {
            historyDao.insert(it)
        }
    }
}
