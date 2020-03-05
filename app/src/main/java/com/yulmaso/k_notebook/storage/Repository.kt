package com.yulmaso.k_notebook.storage

import com.yulmaso.k_notebook.storage.model.Hashtag
import com.yulmaso.k_notebook.storage.model.Note
import com.yulmaso.k_notebook.storage.room.HashtagDao
import com.yulmaso.k_notebook.storage.room.NoteDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.coroutines.CoroutineContext

@Singleton
class Repository @Inject constructor(
    private val noteDao: NoteDao,
    private val hashtagDao: HashtagDao

    //TODO: make async

)/*: CoroutineScope*/ {

//    override val coroutineContext: CoroutineContext
//        get() = Dispatchers.Main

    fun getAllNotes() = noteDao.getAll()
    fun getDates() = noteDao.getDates()
    fun get(id_note: Int) = noteDao.get(id_note)
    fun insert(note: Note) = noteDao.insert(note)
    fun update(note: Note) = noteDao.update(note)
    fun delete(note: Note) = noteDao.delete(note)
    fun getOnDate(date: String) = noteDao.getOnDate(date)

    fun getAllHashtags() = hashtagDao.getAll()
    fun insert(hashtag: Hashtag) = hashtagDao.insert(hashtag)
    fun update(hashtag: Hashtag) = hashtagDao.update(hashtag)
    fun delete(hashtag: Hashtag) = hashtagDao.delete(hashtag)
    fun getSpecific(id_note: Int) = hashtagDao.getSpecific(id_note)
    fun getNotes(hashtag: String) = hashtagDao.getNotes(hashtag)

//    private suspend fun getAllNotesBG(){
//        withContext(Dispatchers.IO){
//            noteDao.getAll()
//        }
//    }

}