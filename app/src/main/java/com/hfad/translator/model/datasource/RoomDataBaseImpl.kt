package com.hfad.translator.model.datasource

import com.hfad.translator.model.data.DataModel
import io.reactivex.rxjava3.core.Observable

class RoomDataBaseImpl : DataSource<List<DataModel>> {
    override suspend fun getData(word: String): List<DataModel> {
        TODO("Not yet implemented")
    }
}