package com.hfad.translator.model.datasource

import com.hfad.translator.model.data.AppState
import com.hfad.translator.model.data.DataModel
import com.hfad.translator.room.HistoryDao
import com.hfad.translator.utils.convertDataModelSuccessToEntity
import com.hfad.translator.utils.mapHistoryEntityToSearchResult


class RoomDataBaseImpl(private val historyDao: HistoryDao) :
    DataSourceLocal<List<DataModel>> {

    override suspend fun getData(word: String): List<DataModel> {
        return mapHistoryEntityToSearchResult(historyDao.all())
    }
    override suspend fun saveToDB(appState: AppState) {
        convertDataModelSuccessToEntity(appState)?.let {
            historyDao.insert(it)
        }
    }
}
