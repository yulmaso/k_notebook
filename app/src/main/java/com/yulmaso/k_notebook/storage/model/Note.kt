package com.yulmaso.k_notebook.storage.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.yulmaso.k_notebook.storage.room.CalendarConverter
import java.util.*

@Entity(tableName = "notes")
class Note(
    var text: String,
    var date: String,
    var time: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

}