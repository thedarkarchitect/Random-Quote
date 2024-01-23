package com.example.quotes.data.repository

import com.example.quotes.data.remote.QuoteApi
import com.example.quotes.data.remote.dto.QuoteDto
import com.example.quotes.domain.repository.QuoteRepository
import com.example.quotes.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class QuoteRepositoryImpl @Inject constructor(
    private val api: QuoteApi
): QuoteRepository {
    override suspend fun getQuote(): Flow<Resource<QuoteDto>> = flow {
        emit(Resource.Loading())
        try {
            val result = api.getRandomQuote()
            emit(Resource.Success(data = result))
            return@flow
        } catch (e: Exception) {
            e.printStackTrace()
            emit(Resource.Error(data = null, message = "Error Loading Quote"))
            return@flow
        }
    }
}