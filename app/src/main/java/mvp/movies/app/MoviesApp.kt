package mvp.movies.app

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import mvp.movies.app.di.component.DaggerApplicationComponent
import timber.log.Timber

class MoviesApp: DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerApplicationComponent.factory().create(this)
    }

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}