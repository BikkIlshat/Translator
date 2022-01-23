package com.hfad.repository

import com.hfad.model.DataModel
import com.hfad.repository.api.ApiService


class RetrofitImpl(private val apiService: ApiService) : DataSource<List<DataModel>> {


    override suspend fun getData(word: String): List<DataModel> {
        return apiService.searchAsync(word)
    }



    companion object {
        const val BASE_URL_LOCATIONS = "https://dictionary.skyeng.ru/api/public/v1/"
    }
}