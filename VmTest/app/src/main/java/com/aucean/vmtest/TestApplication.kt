package com.aucean.vmtest

import android.app.Application
import android.content.Context

class TestApplication : Application(){
    companion object {
        lateinit var appContext: Context
    }
    override fun onCreate() {
        super.onCreate()
        appContext = applicationContext
    }
}