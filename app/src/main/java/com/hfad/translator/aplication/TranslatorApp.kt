package com.hfad.translator.aplication

import android.app.Application
import com.hfad.translator.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class TranslatorApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(applicationContext)
            modules(listOf( mainScreenModule,repositoryModule,viewModelModule, historyScreen))
        }
    }
}