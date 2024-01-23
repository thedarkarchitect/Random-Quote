package com.example.quotes.di

import com.example.quotes.data.remote.QuoteApi
import com.example.quotes.data.repository.QuoteRepositoryImpl
import com.example.quotes.domain.repository.QuoteRepository
import com.example.quotes.utils.constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideRetrofit(): QuoteApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(QuoteApi::class.java)
    }

    @Provides
    @Singleton
    fun provideQuoteRepository(
        api: QuoteApi
    ): QuoteRepository = QuoteRepositoryImpl(api)
}