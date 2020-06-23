package mvp.movies.app.ui.movies

import dagger.Binds
import dagger.Module
import mvp.movies.app.di.annotations.PerActivity
import mvp.movies.app.ui.movies.data.MoviesRepositoryImpl
import javax.inject.Singleton

@Suppress("unused")
@Module
abstract class MoviesModule {

    @Binds
    @PerActivity
    abstract fun provideMoviesActivityView(moviesActivity: MoviesActivity): MovieContract.View

    @Binds
    @PerActivity
    abstract fun provideMoviesRepository(moviesRepositoryImpl: MoviesRepositoryImpl): MovieContract.MoviesRepository

    @Binds
    @PerActivity
    abstract fun provideMoviesPresenter(moviesPresenter: MoviesPresenter): MovieContract.Presenter

}