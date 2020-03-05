package com.yulmaso.k_notebook.storage.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Ignore

@Entity(
    tableName = "hashtags", foreignKeys = [ForeignKey(
        entity = Note::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("id_note"),
        onDelete = ForeignKey.CASCADE)],
    primaryKeys = ["id_note", "hashtag"]
)
class Hashtag {
    var id_note: Int = 0
    var hashtag: String = ""
    @Ignore
    var color: String? = null
}