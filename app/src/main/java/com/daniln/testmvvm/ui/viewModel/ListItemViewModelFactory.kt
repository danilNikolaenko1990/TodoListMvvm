package com.daniln.testmvvm.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.daniln.testmvvm.domain.ItemRepository

class ListItemViewModelFactory(private val itemRepository: ItemRepository) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ListItemViewModel(itemRepository) as T
    }
}