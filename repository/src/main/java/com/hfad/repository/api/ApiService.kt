package com.hfad.repository.api

import com.hfad.model.DataModel
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiService {

    @GET("words/search")
    suspend fun searchAsync(@Query("search") wordToSearch: String): List<DataModel>
}