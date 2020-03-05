package com.yulmaso.k_notebook.di

import com.yulmaso.k_notebook.ui.MainActivity
import com.yulmaso.k_notebook.ui.calendar.CalendarFragment
import com.yulmaso.k_notebook.ui.home.HomeFragment
import com.yulmaso.k_notebook.ui.htags.HtagsFragment
import com.yulmaso.k_notebook.ui.note.NoteFragment
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityModule {
    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity

    @ContributesAndroidInjector
    abstract fun contributesHomeFragment(): HomeFragment

    @ContributesAndroidInjector
    abstract fun contributesCalendarFragment(): CalendarFragment

    @ContributesAndroidInjector
    abstract fun contributesHtagsFragment(): HtagsFragment

    @ContributesAndroidInjector
    abstract fun contributesNoteFragment(): NoteFragment
}