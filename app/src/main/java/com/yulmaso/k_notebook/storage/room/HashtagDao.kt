package com.yulmaso.k_notebook.storage.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.yulmaso.k_notebook.storage.model.Hashtag

@Dao
interface HashtagDao {

    @Insert
    fun insert(hashtag: Hashtag)

    @Update
    fun update(hashtag: Hashtag)

    @Delete
    fun delete(hashtag: Hashtag)

    @Query("SELECT * FROM hashtags GROUP BY hashtag ORDER BY hashtag")
    fun getAll(): LiveData<List<Hashtag>>

    @Query("SELECT * FROM hashtags WHERE id_note = :id_note ORDER BY hashtag")
    fun getSpecific(id_note: Int): LiveData<List<Hashtag>>

    @Query("SELECT id_note FROM hashtags WHERE hashtag = :hashtag")
    fun getNotes(hashtag: String): LiveData<List<Int>>

}