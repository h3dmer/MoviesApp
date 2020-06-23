package mvp.movies.app.ui.moviedetails

import dagger.Binds
import dagger.Module
import mvp.movies.app.di.annotations.PerActivity
import mvp.movies.app.ui.movies.MovieContract
import mvp.movies.app.ui.movies.MoviesPresenter

@Suppress("unused")
@Module
abstract class MovieDetailModule {

    @Binds
    @PerActivity
    abstract fun provideMovieDetailActivityView(movieDetailActivity: MovieDetailActivity): MovieDetailContract.View

    @Binds
    @PerActivity
    abstract fun provideMovieDetailsPresenter(movieDetailPresenter: MovieDetailPresenter): MovieDetailContract.Presenter

}