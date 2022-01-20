package com.hfad.translator.model.repository

import com.hfad.translator.model.data.DataModel
import com.hfad.translator.model.datasource.DataSource


class RepositoryImpl(private val dataSource: DataSource<List<DataModel>>) :
    Repository<List<DataModel>> {

    override suspend fun getData(word: String): List<DataModel> {
        return dataSource.getData(word)
    }
}
