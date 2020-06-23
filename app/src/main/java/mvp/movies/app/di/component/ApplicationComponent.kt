package mvp.movies.app.di.component

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import mvp.movies.app.MoviesApp
import mvp.movies.app.di.modules.ActivityBindingModule
import mvp.movies.app.di.modules.NetworkModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ActivityBindingModule::class,
        NetworkModule::class
    ]
)
interface ApplicationComponent : AndroidInjector<MoviesApp> {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): ApplicationComponent
    }

}