package com.hfad.translator.datasource

import com.hfad.translator.data.DataModel
import io.reactivex.rxjava3.core.Observable

class RoomDataBaseImpl : DataSource<List<DataModel>> {
    override fun getData(word: String): Observable<List<DataModel>> {
        TODO("Not yet implemented")
    }
}