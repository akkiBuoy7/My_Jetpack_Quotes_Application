package com.example.myjetpackquotesapplication.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FormatQuote
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myjetpackquotesapplication.DataManager
import com.example.myjetpackquotesapplication.model.Quote

@Preview
@Composable
fun QuoteListDetailScreen(quote: Quote) {
    BackHandler {
        DataManager.switchPages(null)
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.sweepGradient(
                    0.5f to Color.White,
                    0.5f to Color(0xFFE3E3E3),
                )
            ),
        contentAlignment = Alignment.Center
    ) {
        Card(
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
            modifier = Modifier.padding(32.dp)
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(16.dp, 16.dp)
            ) {
                Image(
                    imageVector = Icons.Filled.FormatQuote, contentDescription = "detail",
                    modifier = Modifier
                        .size(80.dp)
                        .rotate(180f)
                        .align(Alignment.Start)
                )
                Text(
                    text = quote.text,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(5.dp, 0.dp, 0.dp, 8.dp)
                )
                quote.author?.let {
                    Text(
                        text = it, style = MaterialTheme.typography.bodySmall,
                        fontWeight = FontWeight.ExtraLight,
                        modifier = Modifier
                            .padding(5.dp)
                            .align(Alignment.Start)
                    )
                }
            }

        }
    }
}