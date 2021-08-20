package com.fmaldonado.multinotesxml.activities.main

import androidx.lifecycle.ViewModel
import com.fmaldonado.multinotesxml.services.NotesServices

class MainActivityViewModel : ViewModel() {

    val notes = NotesServices.getNotes()

}