package com.reza.foxsport.modules

import android.content.Context
import com.reza.foxsport.App
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by reza on 4/11/17.
 */
@Module
class AppModule(val app: App) {

    @Provides
    @Singleton
    fun provideApp() = app

    @Provides
    @Singleton
    fun provideContext(): Context {
        return app
    }
}