package com.daniln.testmvvm.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ListItemViewModelFactory : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ListItemViewModel() as T
    }
}