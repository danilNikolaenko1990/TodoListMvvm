package com.daniln.testmvvm.ui.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.daniln.testmvvm.domain.Item
import com.daniln.testmvvm.domain.ItemRepository
import kotlinx.coroutines.*
import androidx.lifecycle.viewModelScope

class ListItemViewModel(private val itemRepository: ItemRepository) : ViewModel() {
    val items: LiveData<List<Item>> = itemRepository.getAll()

    fun add(text: String) {
        viewModelScope.launch(Dispatchers.Main) {
            withContext(Dispatchers.IO) {
                itemRepository.insert(Item(text))
            }
        }
    }

    fun removeAll() {
        viewModelScope.launch(Dispatchers.Main) {
            withContext(Dispatchers.IO) {
                itemRepository.deleteAll()
            }
        }
    }
}