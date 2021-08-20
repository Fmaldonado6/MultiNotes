package com.fmaldonado.multinotescompose.screens.detail

import androidx.lifecycle.ViewModel
import com.fmaldonado.multinotescompose.NotesService

class DetailScreenViewModel : ViewModel() {

    fun removeNote(index: Int) {
        NotesService.removeNote(index = index)
    }
}