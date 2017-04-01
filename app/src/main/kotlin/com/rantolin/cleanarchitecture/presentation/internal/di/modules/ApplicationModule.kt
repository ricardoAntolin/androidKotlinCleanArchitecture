package com.rantolin.cleanarchitecture.presentation.internal.di.modules

import android.content.Context
import android.content.SharedPreferences
import com.rantolin.cleanarchitecture.data.executor.JobExecutor
import com.rantolin.cleanarchitecture.data.repository.DataRepository
import com.rantolin.cleanarchitecture.domain.executor.PostExecutionThread
import com.rantolin.cleanarchitecture.domain.executor.ThreadExecutor
import com.rantolin.cleanarchitecture.domain.repository.Repository
import com.rantolin.cleanarchitecture.presentation.AndroidApplication
import com.rantolin.cleanarchitecture.presentation.UIThread
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


/**
 * Dagger module that provides objects which will live during the application lifecycle.
 */
@Module
class ApplicationModule(private val androidApplication: AndroidApplication) {

    @Provides
    @Singleton
    fun application(): AndroidApplication {
        return androidApplication
    }

    @Provides
    @Singleton
    fun provideApplicationContext(): Context {
        return androidApplication
    }

    @Provides
    @Singleton
    fun provideThreadExecutor(jobExecutor: JobExecutor): ThreadExecutor {
        return jobExecutor
    }

    @Provides
    @Singleton
    fun providePostExecutionThread(uiThread: UIThread): PostExecutionThread {
        return uiThread
    }

    @Provides
    @Singleton
    fun provideSharedPreferences(): SharedPreferences {
        return androidApplication.getSharedPreferences("app", Context.MODE_APPEND)
    }

    @Provides
    @Singleton
    fun provideRepository(dataRepository: DataRepository): Repository {
        return dataRepository

    }
}
