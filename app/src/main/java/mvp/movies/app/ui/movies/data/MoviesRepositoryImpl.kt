package mvp.movies.app.ui.movies.data

import io.reactivex.Single
import mvp.movies.app.api.service.IMoviesApi
import mvp.movies.app.api.dto.DiscoverResponse
import mvp.movies.app.di.annotations.PerActivity
import mvp.movies.app.ui.movies.MovieContract
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MoviesRepositoryImpl @Inject constructor(
    private val moviesService: IMoviesApi
) : MovieContract.MoviesRepository {

    override fun getPopularMovies(): Single<DiscoverResponse> =
        moviesService.getPopularMovies()
}