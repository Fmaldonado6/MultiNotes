package com.fmaldonado.multinotesxml.activities.add

import androidx.lifecycle.ViewModel
import com.fmaldonado.multinotesxml.models.Note
import com.fmaldonado.multinotesxml.services.NotesServices

class AddActivityViewModel : ViewModel() {

    fun addNote(title: String, descrition: String) {
        NotesServices.addNote(Note(title, descrition))
    }

}