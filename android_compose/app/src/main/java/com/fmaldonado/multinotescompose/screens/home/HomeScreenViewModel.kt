package com.fmaldonado.multinotescompose.screens.home

import androidx.lifecycle.ViewModel
import com.fmaldonado.multinotescompose.NotesService

class HomeScreenViewModel : ViewModel() {
    val notes = NotesService.getNotes()
}