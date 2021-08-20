package com.fmaldonado.multinotescompose.screens.detail

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.fmaldonado.multinotescompose.models.Note
import com.fmaldonado.multinotescompose.models.ParcelableKeys

@Composable
fun DetailScreen(
    viewModel: DetailScreenViewModel,
    navController: NavController
) {

    var openDialog by remember { mutableStateOf(false) }

    val note = remember {
        navController
            .previousBackStackEntry
            ?.arguments
            ?.getParcelable<Note>(
                ParcelableKeys.Note.name
            )
    }

    val index = remember {
        navController
            .previousBackStackEntry
            ?.arguments
            ?.getInt(
                ParcelableKeys.NoteIndex.name
            )
    }

    if (note == null || index == null)
        navController.popBackStack()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(note!!.title)
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Go back")
                    }
                }
            )
        }
    ) {
        if (openDialog) {
            AlertDialog(
                onDismissRequest = {
                    openDialog = false
                },
                title = { Text("Delete note", fontSize = 20.sp) },
                text = { Text("Are you sure you would like to delete this note?") },
                confirmButton = {
                    TextButton(onClick = { openDialog = false }) {
                        Text("Cancel")
                    }
                },
                dismissButton = {
                    TextButton(onClick = {
                        openDialog = false
                        viewModel.removeNote(index = index!!)
                        navController.popBackStack()
                    }) {
                        Text("Delete")
                    }
                }
            )
        }
        DetailContent(note!!, deleteClicked = {
            openDialog = true
        })
    }
}

@Composable
fun DetailContent(note: Note, deleteClicked: () -> Unit) {

    Column(
        modifier = Modifier.padding(16.dp)
    ) {

        Text(
            "Description",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 15.dp)
        )
        Text(note.description, fontSize = 15.sp, modifier = Modifier.padding(bottom = 15.dp))
        OutlinedButton(
            onClick = { deleteClicked() },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.outlinedButtonColors(
                contentColor = Color.Red
            ),
        ) {
            Text("Delete note")
        }

    }

}