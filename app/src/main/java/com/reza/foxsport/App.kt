package com.reza.foxsport

import android.app.Application
import android.content.Context
import android.os.StrictMode
import com.reza.foxsport.components.AppComponent
import com.reza.foxsport.components.DaggerAppComponent
import com.reza.foxsport.modules.AppModule
import com.reza.foxsport.modules.NetworkModule

/**
 * Created by reza on 4/11/17.
 */
class App: Application() {

    companion object {
        fun get(context: Context): App {
            return context.applicationContext as App
        }
    }

    val appComponent: AppComponent by lazy {
        DaggerAppComponent
                .builder()
                .appModule(AppModule(this))
                .networkModule(NetworkModule())
                .build()
    }

    override fun onCreate() {
        super.onCreate()
        appComponent.inject(this)
    }
}