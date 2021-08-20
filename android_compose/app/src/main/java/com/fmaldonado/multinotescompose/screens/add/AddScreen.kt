package com.fmaldonado.multinotescompose.screens.add

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun AddScreen(
    navController: NavController,
    viewModel: AddScreenViewModel
) {

    val title by viewModel.title.observeAsState("")
    val description by viewModel.description.observeAsState("")

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Add Note")
                }
            )


        },
    ) {
        AddNoteForm(
            title = title,
            description = description,
            onTitleChange = { viewModel.setTitle(title = it) },
            onDescriptionChange = { viewModel.setDescription(description = it) },
            onButtonPressed = {
                viewModel.addNote(title, description)
                navController.popBackStack()
            }
        )
    }
}

@Composable
fun AddNoteForm(
    title: String,
    description: String,
    onTitleChange: (String) -> Unit,
    onDescriptionChange: (String) -> Unit,
    onButtonPressed: () -> Unit
) {
    Column(
        modifier = Modifier.padding(16.dp)

    ) {
        OutlinedTextField(
            value = title,
            onValueChange = onTitleChange,
            label = { Text("Note title") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 15.dp)

        )
        OutlinedTextField(
            value = description,
            onValueChange = onDescriptionChange,
            label = { Text("Note description") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 15.dp)
        )
        OutlinedButton(
            onClick = onButtonPressed,
            enabled = title.isNotEmpty() && description.isNotEmpty(),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Add note")
        }
    }
}