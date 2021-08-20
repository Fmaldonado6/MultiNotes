package com.fmaldonado.multinotescompose.screens.add

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fmaldonado.multinotescompose.NotesService
import com.fmaldonado.multinotescompose.models.Note

class AddScreenViewModel : ViewModel() {

    val title = MutableLiveData<String>("")
    val description = MutableLiveData<String>("")

    fun setTitle(title: String) {
        this.title.value = title
    }

    fun setDescription(description: String) {
        this.description.value = description
    }

    fun addNote(title: String, description: String) {
        NotesService.addNote(Note(title,description))
    }

}
