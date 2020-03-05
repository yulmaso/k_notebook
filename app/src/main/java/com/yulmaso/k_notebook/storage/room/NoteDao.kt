package com.yulmaso.k_notebook.storage.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.yulmaso.k_notebook.storage.model.Note

@Dao
interface NoteDao {

    @Insert
    fun insert(note: Note)

    @Update
    fun update(note: Note)

    @Delete
    fun delete(note: Note)

    @Query("SELECT * FROM notes WHERE id = :id")
    fun get(id: Int): LiveData<Note>

    @Query("SELECT * FROM notes ORDER BY date DESC, time DESC")
    fun getAll(): LiveData<List<Note>>

    @Query("SELECT * FROM notes WHERE date LIKE :date ORDER BY time DESC")
    fun getOnDate(date: String): LiveData<List<Note>>

    @Query("SELECT date FROM notes GROUP BY date ORDER BY date DESC")
    fun getDates(): LiveData<List<String>>

}