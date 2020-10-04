package sdim.example.cats.di

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import sdim.example.cats.data.net.ApiConstants
import sdim.example.cats.data.net.ApiKeyInterceptor
import sdim.example.cats.data.net.CatsApiService
import javax.inject.Singleton


class AppModule {
    @Singleton
    fun provideCatsApiService(apiKeyInterceptor: ApiKeyInterceptor): CatsApiService? {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        val httpClient: OkHttpClient =
            OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .addInterceptor(apiKeyInterceptor)
                .build()

        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(ApiConstants.ENDPOINT)
            .client(httpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(CatsApiService::class.java)
    }
}