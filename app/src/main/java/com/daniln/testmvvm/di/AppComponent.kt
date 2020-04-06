package com.daniln.testmvvm.di

import android.content.Context
import com.daniln.testmvvm.ui.fragments.TodoListFragment
import dagger.BindsInstance
import dagger.Component

@Component(modules = [DatabaseModule::class, ViewModelModule::class])
interface AppComponent {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }

    fun inject(fragment: TodoListFragment)
}