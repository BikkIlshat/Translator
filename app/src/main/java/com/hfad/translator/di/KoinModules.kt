package com.hfad.translator.di

import com.hfad.repository.RetrofitImpl
import com.hfad.repository.api.ApiService
import com.hfad.repository.api.BaseInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val application = module {
    single { provideRetrofit() }
    single { provideService() }
    single { provideOkHttpClient() }
}


private fun provideService(): ApiService {
    return provideRetrofit().create(ApiService::class.java)
}

private fun provideRetrofit(): Retrofit {
    return Retrofit.Builder()
        .baseUrl(RetrofitImpl.BASE_URL_LOCATIONS)
        .addConverterFactory(GsonConverterFactory.create())
        .client(provideOkHttpClient())
        .build()
}


private fun provideOkHttpClient(): OkHttpClient {
    val httpClient = OkHttpClient.Builder()
    httpClient.addInterceptor(BaseInterceptor.interceptor)
    httpClient.addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
    return httpClient.build()
}
