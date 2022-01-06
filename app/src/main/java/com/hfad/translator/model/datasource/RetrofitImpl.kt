package com.hfad.translator.model.datasource

import com.hfad.translator.model.data.DataModel
import com.hfad.translator.model.data.api.ApiService
import com.hfad.translator.model.data.api.BaseInterceptor
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitImpl(private val apiService: ApiService) : DataSource<List<DataModel>> {


    override suspend fun getData(word: String): List<DataModel> {
        return apiService.searchAsync(word)
    }



    companion object {
        const val BASE_URL_LOCATIONS = "https://dictionary.skyeng.ru/api/public/v1/"
    }
}