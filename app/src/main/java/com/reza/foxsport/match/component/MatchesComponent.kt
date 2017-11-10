package com.reza.foxsport.match.component

import com.reza.foxsport.match.module.FragmentScope
import com.reza.foxsport.match.module.MatchesModule
import com.reza.foxsport.match.view.MatchesFragment
import dagger.Subcomponent
import javax.inject.Singleton

/**
 * Created by reza on 6/11/17.
 */
@FragmentScope
@Subcomponent(modules = arrayOf(MatchesModule::class))
interface MatchesComponent {
    fun inject(matchesFragment: MatchesFragment)
}