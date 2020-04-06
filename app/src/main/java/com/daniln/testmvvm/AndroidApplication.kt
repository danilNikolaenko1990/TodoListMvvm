package com.daniln.testmvvm

import android.app.Application
import com.daniln.testmvvm.di.AppComponent
import com.daniln.testmvvm.di.DaggerAppComponent

class AndroidApplication : Application() {
    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create(applicationContext)
    }
}
