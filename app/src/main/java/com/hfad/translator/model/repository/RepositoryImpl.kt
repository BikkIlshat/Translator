package com.hfad.translator.model.repository

import com.hfad.translator.model.data.DataModel
import com.hfad.translator.model.datasource.DataSource
import io.reactivex.rxjava3.core.Observable


/**
 * Репозиторий возвращает данные, используя dataSource (локальный или внешний)
 */
class RepositoryImpl(private val dataSource: DataSource<List<DataModel>>) :
    Repository<List<DataModel>> {

    override fun getData(word: String): Observable<List<DataModel>> {
        return dataSource.getData(word)
    }
}

