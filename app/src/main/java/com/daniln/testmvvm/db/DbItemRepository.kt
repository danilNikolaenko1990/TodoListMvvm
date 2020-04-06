package com.daniln.testmvvm.db

import androidx.lifecycle.LiveData
import com.daniln.testmvvm.domain.Item
import com.daniln.testmvvm.domain.ItemDao
import com.daniln.testmvvm.domain.ItemRepository

class DbItemRepository(private val dao: ItemDao) : ItemRepository {
    override fun getAll(): LiveData<List<Item>> {
        return dao.getAll()
    }

    override suspend fun insert(item: Item) {
        dao.insert(item)
    }
}