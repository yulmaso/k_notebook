package com.yulmaso.k_notebook.ui.note

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.yulmaso.k_notebook.storage.model.Note
import com.yulmaso.k_notebook.storage.Repository
import javax.inject.Inject

class NoteViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    var note: LiveData<Note>? = null

    fun setNote(idNote: Int){
        note = repository.get(idNote)
    }

}