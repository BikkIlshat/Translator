package com.hfad.translator.model.datasource

import com.hfad.translator.model.data.DataModel

class DataSourceLocal(
    private val remoteProvider: RoomDataBaseImpl =
        RoomDataBaseImpl()
) :
    DataSource<List<DataModel>> {

    override suspend fun getData(word: String): List<DataModel> =
        remoteProvider.getData(word)
}
