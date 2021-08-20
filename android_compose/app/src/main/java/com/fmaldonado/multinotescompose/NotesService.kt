package com.fmaldonado.multinotescompose

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.fmaldonado.multinotescompose.models.Note

object NotesService {

    private val notes = mutableListOf<Note>()
    private val liveNotes = MutableLiveData<List<Note>>()

    fun getNotes() = liveNotes as LiveData<List<Note>>

    fun addNote(note: Note) {
        notes.add(note)
        liveNotes.value = notes
    }

    fun removeNote(index: Int) {
        notes.removeAt(index)
        liveNotes.value = notes
    }

}