package mvp.movies.app.api.service

import io.reactivex.Single
import mvp.movies.app.api.dto.DiscoverResponse
import mvp.movies.app.util.Constants
import retrofit2.http.GET

interface IMoviesApi {

    @GET("3/discover/movie?api_key=${Constants.API_KEY}")
    fun getPopularMovies(): Single<DiscoverResponse>
}