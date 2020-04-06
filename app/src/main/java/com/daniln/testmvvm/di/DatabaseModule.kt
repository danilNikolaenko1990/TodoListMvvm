package com.daniln.testmvvm.di

import android.content.Context
import com.daniln.testmvvm.db.AppDatabase
import com.daniln.testmvvm.db.DbItemRepository
import com.daniln.testmvvm.domain.ItemDao
import com.daniln.testmvvm.domain.ItemRepository
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import javax.inject.Scope
import javax.inject.Singleton

@Module
class DatabaseModule {
    @Singleton
    @Provides
    fun providesItemsDao(database: AppDatabase) = database.getItemsDao()

    @Singleton
    @Provides
    fun provideAppDatabase(context: Context): AppDatabase = AppDatabase.getDatabase(context)

    @Singleton
    @Provides
    fun provideRepository(itemDao: ItemDao): ItemRepository = DbItemRepository(itemDao)
}