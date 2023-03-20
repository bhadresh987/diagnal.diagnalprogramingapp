package com.diagnal.diagnalprogramingapp

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.diagnal.diagnalprogramingapp.models.Content
import com.diagnal.diagnalprogramingapp.models.Page
import com.diagnal.diagnalprogramingapp.utils.Utils
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MainViewModel(private val utils: Utils): ViewModel() {
    private val mutableCards = MutableLiveData<List<Content>>()
    val cards: LiveData<List<Content>> get() = mutableCards

    fun fetchCards(context: Context) {
        val jsonString = utils.getJson(context, "page.json")

        val gson = Gson()
        val listCardType = object: TypeToken<Page>() {}.type

        val cards = gson.fromJson<Page>(jsonString, listCardType)
        mutableCards.value = cards.page.contentItems.content
    }
}