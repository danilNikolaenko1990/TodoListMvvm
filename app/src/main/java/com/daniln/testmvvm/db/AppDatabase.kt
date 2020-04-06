package com.daniln.testmvvm.db

import android.content.Context
import androidx.room.*
import com.daniln.testmvvm.domain.Item
import com.daniln.testmvvm.domain.ItemDao
import kotlinx.coroutines.CoroutineScope
import javax.inject.Singleton

@Database(entities = [Item::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getItemsDao(): ItemDao

    companion object {
        fun getDatabase(
            context: Context
        ): AppDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "items-db"
            )
                .build()
        }
    }
}