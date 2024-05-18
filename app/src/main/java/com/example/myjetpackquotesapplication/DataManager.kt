package com.example.myjetpackquotesapplication

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import com.example.myjetpackquotesapplication.model.Quote
import com.google.gson.Gson

object DataManager {
    var data = emptyArray<Quote>()
    var currentPage = mutableStateOf(Pages.LISTSCREEN)
    var currentQuote: Quote? = null
    var isDataLoaded = mutableStateOf(false)

    fun loadAssets(context: Context) {
        val inputStream = context.assets.open("quotes.json")
        val size: Int = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer, Charsets.UTF_8)
        val gson = Gson()
        data = gson.fromJson(json, Array<Quote>::class.java)
        isDataLoaded.value = true
    }

    fun switchPages(quote: Quote?) {
        if (currentPage.value == Pages.LISTSCREEN) {
            currentQuote = quote
            currentPage.value = Pages.DETAILSCREEN
        } else {
            currentPage.value = Pages.LISTSCREEN
        }
    }
}