package com.yulmaso.k_notebook

import android.app.Application
import com.yulmaso.k_notebook.di.AppComponent
import com.yulmaso.k_notebook.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlin.coroutines.CoroutineContext

class App : DaggerApplication(){

    override fun applicationInjector(): AndroidInjector<out DaggerApplication>
        = DaggerAppComponent.builder().application(this).build();
}