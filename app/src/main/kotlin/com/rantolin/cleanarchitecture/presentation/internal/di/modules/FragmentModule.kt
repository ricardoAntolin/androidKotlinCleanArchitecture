package com.rantolin.cleanarchitecture.presentation.internal.di.modules

import android.support.v4.app.Fragment
import com.rantolin.cleanarchitecture.presentation.internal.di.scope.PerFragment
import dagger.Module
import dagger.Provides

@Module
class FragmentModule(private val baseFragment: Fragment) {

    @Provides
    @PerFragment
    fun provideFragment(): Fragment {
        return this.baseFragment
    }
}