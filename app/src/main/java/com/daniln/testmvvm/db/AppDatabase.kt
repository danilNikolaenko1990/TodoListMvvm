package com.daniln.testmvvm.db

import android.content.Context
import androidx.room.*
import com.daniln.testmvvm.domain.Item
import com.daniln.testmvvm.domain.ItemDao
import kotlinx.coroutines.CoroutineScope

@Database(entities = [Item::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getItemsDao(): ItemDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(
            context: Context
        ): AppDatabase {

            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "items-db"
                )
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}