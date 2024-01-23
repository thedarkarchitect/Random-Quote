package com.example.quotes.presentation.quote.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.quotes.presentation.quote.QuoteState

@Composable
fun QuoteScreen(
    modifier: Modifier = Modifier,
    state: QuoteState
){
    Column {
        state.quote?.let { Text(text = it.content) }
        state.quote?.let { Text(text = it.author) }
    }
}