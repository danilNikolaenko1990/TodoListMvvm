package com.daniln.testmvvm.di


import com.daniln.testmvvm.domain.ItemRepository
import com.daniln.testmvvm.ui.viewModels.ListItemViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ViewModelModule {
    @Provides
    fun provideViewModelFactory(itemsRepository: ItemRepository): ListItemViewModelFactory =
        ListItemViewModelFactory(itemsRepository)
}