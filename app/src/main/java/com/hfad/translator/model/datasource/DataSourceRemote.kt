package com.hfad.translator.model.datasource

import com.hfad.translator.model.data.DataModel

class DataSourceRemote(
    private val remoteProvaider: RetrofitImpl = RetrofitImpl()
) : DataSource<List<DataModel>> {

    override suspend fun getData(word: String): List<DataModel> =
        remoteProvaider.getData(word)

}