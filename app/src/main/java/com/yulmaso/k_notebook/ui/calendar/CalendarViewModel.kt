package com.yulmaso.k_notebook.ui.calendar

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.applandeo.materialcalendarview.EventDay
import com.yulmaso.k_notebook.storage.Repository
import com.yulmaso.k_notebook.storage.model.Note
import com.yulmaso.k_notebook.util.LOG_TAG
import com.yulmaso.k_notebook.util.calendarToString
import java.util.*
import javax.inject.Inject

class CalendarViewModel @Inject constructor(val repository: Repository): ViewModel() {

    lateinit var notes: LiveData<List<Note>> //TODO: DOESN'T WORK
    var dates: LiveData<List<String>> = repository.getDates()

    fun refreshList(day: Calendar){
        notes = repository.getOnDate(calendarToString(day))
        Log.d(LOG_TAG, "date on refresh: "+ calendarToString(day))
        Log.d(LOG_TAG, "returned data: "+ notes.value?.get(1))
    }

}