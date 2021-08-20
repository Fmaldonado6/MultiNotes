package com.fmaldonado.multinotesxml.services

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.fmaldonado.multinotesxml.adapter.NotesAdapter
import com.fmaldonado.multinotesxml.models.Note

object NotesServices {

    private val notes = mutableListOf<Note>()
    private val liveNotes = MutableLiveData<List<Note>>(notes)

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