package com.example.quotes.data.remote

import com.example.quotes.data.remote.dto.QuoteDto
import retrofit2.http.GET

interface QuoteApi {
    @GET("random")
    suspend fun getRandomQuote(): QuoteDto
}