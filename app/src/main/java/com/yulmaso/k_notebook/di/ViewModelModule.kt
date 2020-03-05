package com.yulmaso.k_notebook.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.yulmaso.k_notebook.ui.calendar.CalendarViewModel
import com.yulmaso.k_notebook.ui.home.HomeViewModel
import com.yulmaso.k_notebook.ui.htags.HtagsViewModel
import com.yulmaso.k_notebook.ui.note.NoteViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindHomeViewModel(homeViewModel: HomeViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(CalendarViewModel::class)
    abstract fun bindCalendarViewModel(calendarViewModel: CalendarViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(HtagsViewModel::class)
    abstract fun bindHtagsViewModel(htagsViewModel: HtagsViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(NoteViewModel::class)
    abstract fun bindNoteViewModel(noteViewModel: NoteViewModel) : ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory) : ViewModelProvider.Factory

}