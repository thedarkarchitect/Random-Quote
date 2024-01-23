package com.example.quotes.presentation.quote.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.quotes.R
import com.example.quotes.data.remote.dto.QuoteDto
import com.example.quotes.presentation.quote.QuoteEvent
import com.example.quotes.presentation.quote.QuoteState
import com.example.quotes.ui.theme.QuotesTheme

@Composable
fun QuoteScreen(
    modifier: Modifier = Modifier,
    state: QuoteState,
    event: (QuoteEvent) -> Unit
){

    Scaffold{ innerPadding ->
        Box(
            modifier = modifier
                .padding(innerPadding)
        ){
            Image(
                painter = painterResource(id = R.drawable.trees4),
                contentDescription = null,
                contentScale = ContentScale.FillHeight//this scales the image to fit the whole screen
            )

            Column(
                modifier = modifier.padding(top = 300.dp, start = 16.dp, end = 16.dp),

            ){
                OutlinedCard(
                    colors = CardDefaults.cardColors(
                        containerColor = Color.Transparent,
                        contentColor = Color.White
                    ),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 10.dp
                    ),
                    modifier = modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = modifier
                            .padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                    ){
                        state.quote?.content?.let {
                            Text(
                                text = it
                            )
                        }
                        Spacer(modifier = modifier.height(12.dp))
                        Divider()
                        Spacer(modifier = modifier.height(12.dp))
                        state.quote?.author?.let {
                            Text(
                                text = it
                            )
                        }
                    }
                }
                OutlinedButton(
                    modifier = modifier
                        .padding(8.dp)
                        .align(Alignment.CenterHorizontally)
                        .fillMaxWidth()
                    ,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent,
                    ),
                    shape = RoundedCornerShape(5.dp),
                    onClick = { event(QuoteEvent.ButtonClicked) }
                ) {
                    Text(text = "Quote")
                }
            }
        }
    }
}

@Preview
@Composable
fun QuotePreview() {
    QuotesTheme {
        QuoteScreen(
            state = QuoteState(
                isLoading = false,
                QuoteDto(
                id = "xwABJFIJQVwW",
                content = "We need to find the courage to say NO to the things and people that are not serving us if we want to rediscover ourselves and live our lives with authenticity.",
                author = "Barbara De Angelis",
                tags = listOf("Life", "Wisdom"),
                authorSlug = "barbara-de-angelis",
                length = 159,
                dateAdded = "2019-02-13",
                dateModified = "2023-04-14"
                )
            ),
            event = {}
        )
    }
}