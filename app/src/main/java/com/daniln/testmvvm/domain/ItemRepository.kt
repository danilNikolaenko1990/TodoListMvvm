package com.daniln.testmvvm.domain

import androidx.lifecycle.LiveData

interface ItemRepository {
    fun getAll(): LiveData<List<Item>>
    suspend fun insert(item: Item)
}