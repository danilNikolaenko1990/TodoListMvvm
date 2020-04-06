package com.daniln.testmvvm.domain

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ItemDao {
    @Query("SELECT * FROM Item")
    fun getAll(): LiveData<List<Item>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(item: Item)
}