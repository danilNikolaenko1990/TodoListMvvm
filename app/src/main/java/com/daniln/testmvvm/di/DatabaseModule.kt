package com.daniln.testmvvm.di

import android.content.Context
import com.daniln.testmvvm.db.AppDatabase
import com.daniln.testmvvm.db.DbItemRepository
import com.daniln.testmvvm.domain.ItemDao
import com.daniln.testmvvm.domain.ItemRepository
import dagger.Module
import dagger.Provides

@Module
class DatabaseModule {
    @Provides
    fun providesItemsDao(database: AppDatabase) = database.getItemsDao()

    @Provides
    fun provideAppDatabase(context: Context): AppDatabase = AppDatabase.getDatabase(context)

    @Provides
    fun provideRepository(itemDao: ItemDao): ItemRepository = DbItemRepository(itemDao)
}