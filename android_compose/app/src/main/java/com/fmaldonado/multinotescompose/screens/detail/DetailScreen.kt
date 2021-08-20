package com.fmaldonado.multinotescompose.screens.detail

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import com.fmaldonado.multinotescompose.models.Note
import com.fmaldonado.multinotescompose.models.ParcelableKeys

@Composable
fun DetailScreen(
    viewModel: DetailScreenViewModel,
    navController: NavController
) {

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

    }
}

@Composable
fun DetailContent() {

}