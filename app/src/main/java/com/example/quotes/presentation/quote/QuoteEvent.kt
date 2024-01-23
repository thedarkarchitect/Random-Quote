package com.example.quotes.presentation.quote

sealed class QuoteEvent {
    data object ButtonClicked: QuoteEvent()
}