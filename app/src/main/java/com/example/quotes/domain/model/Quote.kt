package com.example.quotes.domain.model

import com.example.quotes.data.remote.dto.QuoteDto


data class Quote(
    val author: String,
    val authorSlug: String,
    val content: String,
    val dateAdded: String,
    val dateModified: String,
    val id: String,
    val length: Int,
    val tags: List<String>
)
