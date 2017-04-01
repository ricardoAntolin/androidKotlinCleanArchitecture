package com.rantolin.cleanarchitecture.presentation.internal.di.components


import com.rantolin.cleanarchitecture.presentation.internal.di.modules.ActivityModule
import com.rantolin.cleanarchitecture.presentation.internal.di.scope.PerActivity
import com.rantolin.cleanarchitecture.presentation.ui.activities.MainActivity
import dagger.Component

/**
 * A base component upon which fragment's components may depend.
 * Activity-level components should extend this component.
 *
 *
 * Subtypes of ActivityComponent should be decorated with annotation:
 * [PerActivity]
 */
@PerActivity
@Component(dependencies = arrayOf(ApplicationComponent::class), modules = arrayOf(ActivityModule::class))
interface ActivityComponent {

    fun inject(mainActivity: MainActivity)
}
