package com.yulmaso.k_notebook.storage.room

import androidx.room.TypeConverter
import com.yulmaso.k_notebook.util.dateFormat
import java.util.*

class CalendarConverter {

    @TypeConverter
    fun toString(cal: Calendar): String {
        return dateFormat.format(cal)
    }

    @TypeConverter
    fun fromString(date: String): Calendar {
        val cal = Calendar.getInstance()
        cal.time = dateFormat.parse(date)
        return cal
    }

}