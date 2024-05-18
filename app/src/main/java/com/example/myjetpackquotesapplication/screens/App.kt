package com.example.myjetpackquotesapplication.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.myjetpackquotesapplication.DataManager
import com.example.myjetpackquotesapplication.Pages

@Composable
fun App() {
    if (DataManager.isDataLoaded.value) {
        if (DataManager.currentPage.value == Pages.LISTSCREEN) {
            QuoteListScreen(data = DataManager.data) { quote ->
                DataManager.switchPages(quote)

            }
        } else {
            DataManager.currentQuote?.let { QuoteListDetailScreen(quote = it) }
        }

    } else {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = "Loading. . . ",
                style = MaterialTheme.typography.headlineSmall
            )
        }
    }
}