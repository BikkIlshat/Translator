package com.hfad.translator.datasource

import com.hfad.translator.data.DataModel
import io.reactivex.rxjava3.core.Observable

class DataSourceRemote(
    private val remoteProvaider: RetrofitImpl = RetrofitImpl()
) : DataSource<List<DataModel>> {

    override fun getData(word: String): Observable<List<DataModel>> =
        remoteProvaider.getData(word)

}