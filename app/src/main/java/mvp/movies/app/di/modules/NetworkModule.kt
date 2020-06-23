package mvp.movies.app.di.modules

import android.content.Context
import dagger.Module
import dagger.Provides
import mvp.movies.app.MoviesApp
import mvp.movies.app.api.service.IMoviesApi
import mvp.movies.app.util.Constants
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module(includes = [CoreDataModule::class])
class NetworkModule {

    @Provides
    @Singleton
    fun provideContext(moviesApp: MoviesApp): Context = moviesApp

    @Provides
    @Singleton
    fun provideMoviesService(okhttpClient: OkHttpClient, converterFactory: GsonConverterFactory, rxJava2CallAdapterFactory: RxJava2CallAdapterFactory) =
        provideService(okhttpClient, converterFactory, rxJava2CallAdapterFactory, IMoviesApi::class.java)

    @Provides
    @Singleton
    fun providesRetrofit(
        gsonConverterFactory: GsonConverterFactory,
        rxJava2CallAdapterFactory: RxJava2CallAdapterFactory,
        okHttpClient: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(gsonConverterFactory)
            .addCallAdapterFactory(rxJava2CallAdapterFactory)
            .client(okHttpClient)
            .build()
    }

    private fun <T> provideService(okHttpClient: OkHttpClient,
                                   converterFactory: GsonConverterFactory,
                                   rxJava2CallAdapterFactory: RxJava2CallAdapterFactory,
                                   clazz: Class<T>): T {
        return providesRetrofit(converterFactory, rxJava2CallAdapterFactory,
            okHttpClient).create(clazz)
    }
}