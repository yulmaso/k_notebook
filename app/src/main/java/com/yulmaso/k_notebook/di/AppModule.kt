package com.yulmaso.k_notebook.di

import android.app.Application
import androidx.annotation.NonNull
import com.yulmaso.k_notebook.storage.Repository
import com.yulmaso.k_notebook.storage.room.AppDatabase
import com.yulmaso.k_notebook.storage.room.HashtagDao
import com.yulmaso.k_notebook.storage.room.NoteDao
import dagger.Module
import dagger.Provides
import org.jetbrains.annotations.NotNull
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class])
class AppModule {

    /**
    * @Provides
    * fun someString(): String = "BLA BLA BLA"
    *
    * //always returns true because this module provides this string
    * @Provides
    * fun isStringNull(string: String): Boolean = string == "BLA BLA BLA"*/

    @Singleton
    @Provides
    fun provideDb(application: Application) = AppDatabase.getInstance(application)

    @Singleton
    @Provides
    fun provideNoteDao(db: AppDatabase) = db.noteDao()

    @Singleton
    @Provides
    fun provideHashtagDao(db: AppDatabase) = db.hashtagDao()

}