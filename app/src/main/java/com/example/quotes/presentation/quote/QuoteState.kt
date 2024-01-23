package com.example.quotes.presentation.quote

import com.example.quotes.data.remote.dto.QuoteDto

data class QuoteState(
    val isLoading: Boolean = false,
    val quote: QuoteDto? = null
)
