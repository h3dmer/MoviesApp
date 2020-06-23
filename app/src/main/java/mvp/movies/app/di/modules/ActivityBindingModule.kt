package mvp.movies.app.di.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import mvp.movies.app.di.annotations.PerActivity
import mvp.movies.app.ui.moviedetails.MovieDetailActivity
import mvp.movies.app.ui.moviedetails.MovieDetailModule
import mvp.movies.app.ui.movies.MoviesActivity
import mvp.movies.app.ui.movies.MoviesModule

@Suppress("unused")
@Module
abstract class ActivityBindingModule {

    @PerActivity
    @ContributesAndroidInjector(modules = [MoviesModule::class])
    abstract fun contributeMoviesActivity(): MoviesActivity

    @PerActivity
    @ContributesAndroidInjector(modules = [MovieDetailModule::class])
    abstract fun contributeMoviesDetailActivity(): MovieDetailActivity
}