package com.yulmaso.k_notebook.ui.calendar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.applandeo.materialcalendarview.EventDay
import com.yulmaso.k_notebook.R
import com.yulmaso.k_notebook.databinding.FragmentCalendarBinding
import com.yulmaso.k_notebook.di.ViewModelFactory
import com.yulmaso.k_notebook.di.injectViewModel
import com.yulmaso.k_notebook.util.stringToCalendar
import dagger.android.support.DaggerFragment
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList

class CalendarFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private lateinit var viewModel: CalendarViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = injectViewModel(viewModelFactory)

        val binding = DataBindingUtil.inflate<FragmentCalendarBinding>(
            inflater, R.layout.fragment_calendar, container, false
        )
        binding.lifecycleOwner = this

        //init calendar
        val currentTime = Calendar.getInstance()
        currentTime.time = Calendar.getInstance().time
        binding.calendar.setDate(currentTime)
        viewModel.refreshList(currentTime)
        binding.calendar.setOnDayClickListener{
            viewModel.refreshList(it.calendar)
            binding.calendar.setDate(it.calendar)
        }
        viewModel.dates.observe(viewLifecycleOwner, Observer {
            val events: MutableList<EventDay> = ArrayList()
            for (date in it) {
                events.add(EventDay(stringToCalendar(date), R.drawable.ic_brightness_1_black_24dp))
            }
            binding.calendar.setEvents(events)
        })

        //init rv
        val adapter = CalendarListAdapter()
        binding.notesOnDateRV.adapter = adapter
        viewModel.notes.observe(viewLifecycleOwner, Observer {
            adapter.setNotes(it)
        })

        return binding.root
    }

}