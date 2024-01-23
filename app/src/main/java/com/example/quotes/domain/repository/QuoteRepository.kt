package com.example.quotes.domain.repository

import com.example.quotes.data.remote.dto.QuoteDto
import com.example.quotes.domain.model.Quote
import com.example.quotes.utils.Resource
import kotlinx.coroutines.flow.Flow


interface QuoteRepository {
    suspend fun getQuote(): Flow<Resource<QuoteDto>>
}