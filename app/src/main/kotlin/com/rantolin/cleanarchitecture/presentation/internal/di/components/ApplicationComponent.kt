
package com.rantolin.cleanarchitecture.presentation.internal.di.components

import android.content.Context
import com.rantolin.cleanarchitecture.domain.executor.PostExecutionThread
import com.rantolin.cleanarchitecture.domain.executor.ThreadExecutor
import com.rantolin.cleanarchitecture.domain.repository.Repository
import com.rantolin.cleanarchitecture.presentation.AndroidApplication
import com.rantolin.cleanarchitecture.presentation.internal.di.modules.ApplicationModule
import dagger.Component
import javax.inject.Singleton

/**
 * A component whose lifetime is the life of the application.
 */
@Singleton // Constraints this component to one-per-application or unscoped bindings.
@Component(modules = arrayOf(ApplicationModule::class))
interface ApplicationComponent {

    fun inject(androidApplication: AndroidApplication)

    val androidApplication: AndroidApplication

    fun context(): Context

    fun threadExecutor(): ThreadExecutor

    fun postExecutionThread(): PostExecutionThread

    fun repository(): Repository
}
