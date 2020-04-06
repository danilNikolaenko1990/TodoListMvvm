package com.daniln.testmvvm.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.daniln.testmvvm.domain.Item
import kotlinx.coroutines.*

class ListItemViewModel : ViewModel() {
    private val itemList = mutableListOf<Item>()

    val items: MutableLiveData<List<Item>> by lazy {
        MutableLiveData<List<Item>>().also {
            GlobalScope.launch(Dispatchers.Main) {
                withContext(Dispatchers.IO) {
                    fetchItems()
                }
                it.value = itemList
            }
        }
    }

    fun add(text: String) {
        GlobalScope.launch(Dispatchers.Main) {
            withContext(Dispatchers.IO) {
                itemList.add(Item(text))
            }
            items.value = itemList
        }
    }

    private suspend fun fetchItems() {
        delay(500)
        itemList.add(Item("test1"))
        itemList.add(Item("test2"))
        itemList.add(Item("test3"))
    }
}