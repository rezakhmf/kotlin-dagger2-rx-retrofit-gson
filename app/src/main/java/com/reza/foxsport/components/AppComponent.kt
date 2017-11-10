package com.reza.foxsport.components

import android.content.Context
import com.reza.foxsport.App
import com.reza.foxsport.match.component.MatchesComponent
import com.reza.foxsport.match.module.FragmentScope
import com.reza.foxsport.match.module.MatchesModule
import com.reza.foxsport.modules.AppModule
import com.reza.foxsport.modules.NetworkModule
import dagger.Component
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by reza on 4/11/17.
 */
@Singleton
@Component(modules = arrayOf(AppModule::class, NetworkModule::class))
interface AppComponent {
    fun inject(app: App)
    fun plus(matchesModule: MatchesModule): MatchesComponent
}