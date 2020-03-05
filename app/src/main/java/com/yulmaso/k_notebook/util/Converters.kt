package com.yulmaso.k_notebook.util

import androidx.room.TypeConverter
import java.text.SimpleDateFormat
import java.util.*

fun calendarToString(cal: Calendar): String {
    return dateFormat.format(cal.time)
}

@TypeConverter
fun stringToCalendar(date: String): Calendar {
    val cal = Calendar.getInstance()
    cal.time = dateFormat.parse(date)
    return cal
}