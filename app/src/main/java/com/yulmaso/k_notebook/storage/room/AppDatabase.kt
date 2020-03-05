package com.yulmaso.k_notebook.storage.room

import android.content.Context
import android.os.AsyncTask
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.yulmaso.k_notebook.storage.model.Hashtag
import com.yulmaso.k_notebook.storage.model.Note

@Database(entities = [Note::class, Hashtag::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun noteDao(): NoteDao
    abstract fun hashtagDao(): HashtagDao
    //TODO: add geotag functionality

    companion object {
        @Volatile
        private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return instance ?: synchronized(this) {
                    instance ?: Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java, "notesDB"
                    )
                        .fallbackToDestructiveMigration()
                        .addCallback(callback)
                        .build()
                        .also { instance = it }
            }
        }

        fun destroyDataBase() {
            instance = null
        }

        private val callback = object: RoomDatabase.Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                PopulateDbAsyncTask(instance!!.noteDao()).execute()
            }
        }

        class PopulateDbAsyncTask(val noteDao: NoteDao) : AsyncTask<Void, Void, Void>(){

            override fun doInBackground(vararg params: Void?): Void? {
                noteDao.insert(Note("It's a first note", "14.11.2020", "12:20"))
                noteDao.insert(Note("Well, it's a second note", "02.03.2013", "11:20"))
                noteDao.insert(Note("Wow! It's a third note!", "01.02.2020", "18:21"))
                noteDao.insert(Note("It's a first note", "14.11.2020", "12:20"))
                noteDao.insert(Note("Well, it's a second note", "02.03.2013", "11:20"))
                noteDao.insert(Note("Wow! It's a third note!", "01.02.2020", "18:21"))
                noteDao.insert(Note("It's a first note", "14.11.2020", "12:20"))
                noteDao.insert(Note("Well, it's a second note", "02.03.2013", "11:20"))
                noteDao.insert(Note("Wow! It's a third note!", "01.02.2020", "18:21"))
                return null
            }
        }
    }
}