package mvp.movies.app.util

import mvp.movies.app.BuildConfig

class Constants {
    companion object {
        const val IMAGE_URL = "https://image.tmdb.org/t/p/w500/"
        const val BASE_URL = "https://api.themoviedb.org/"
        const val API_KEY = BuildConfig.TMDB_SECRET_KEY
    }
}