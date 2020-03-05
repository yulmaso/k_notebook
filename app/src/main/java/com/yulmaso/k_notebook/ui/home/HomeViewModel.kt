package com.yulmaso.k_notebook.ui.home

import androidx.lifecycle.ViewModel
import com.yulmaso.k_notebook.storage.Repository
import javax.inject.Inject

class HomeViewModel @Inject constructor(repository: Repository) : ViewModel() {
    var allNotes = repository.getAllNotes()
}