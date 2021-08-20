package com.fmaldonado.multinotesxml.activities.detail

import androidx.lifecycle.ViewModel
import com.fmaldonado.multinotesxml.services.NotesServices

class DetailActivityViewModel : ViewModel() {

    fun deleteNote(index: Int) {
        NotesServices.removeNote(index)
    }

}