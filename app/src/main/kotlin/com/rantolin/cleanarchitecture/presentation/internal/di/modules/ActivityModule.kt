package com.rantolin.cleanarchitecture.presentation.internal.di.modules

import android.app.Activity
import com.rantolin.cleanarchitecture.presentation.internal.di.scope.PerActivity
import dagger.Module
import dagger.Provides

/**
 * A module to wrap the Activity state and expose it to the graph.
 */
@Module
class ActivityModule(private val baseActivity: Activity) {

    /**
     * Expose the activity to dependents in the graph.
     */
    @Provides
    @PerActivity
    internal fun provideActivity(): Activity {
        return this.baseActivity
    }
}
