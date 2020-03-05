package com.yulmaso.k_notebook.storage.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.yulmaso.k_notebook.storage.model.Geotag

@Dao
interface GeotagDao {

    @Insert
    fun insert(geotag: Geotag)

    @Update
    fun update(geotag: Geotag)

    @Delete
    fun delete(geotag: Geotag)

    @Query("SELECT * FROM geotags ORDER BY date DESC, time DESC")
    fun getAll(): LiveData<List<Geotag>>

}