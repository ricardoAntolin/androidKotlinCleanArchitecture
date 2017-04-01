package com.rantolin.cleanarchitecture.presentation.internal.di.components

import com.rantolin.cleanarchitecture.presentation.internal.di.modules.FragmentModule
import com.rantolin.cleanarchitecture.presentation.internal.di.scope.PerFragment
import com.rantolin.cleanarchitecture.presentation.ui.fragments.MainFragment
import dagger.Component

@PerFragment
@Component(dependencies = arrayOf(ApplicationComponent::class), modules = arrayOf(FragmentModule::class))
interface FragmentComponent {
    fun inject(mainFragment: MainFragment)
}
