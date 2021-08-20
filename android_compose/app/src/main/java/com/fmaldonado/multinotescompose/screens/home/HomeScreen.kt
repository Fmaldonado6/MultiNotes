package com.fmaldonado.multinotescompose.screens.home

import android.os.Bundle
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Help
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.fmaldonado.multinotescompose.NavigationScreen
import com.fmaldonado.multinotescompose.models.Note
import com.fmaldonado.multinotescompose.models.ParcelableKeys

@Composable
fun HomeScreen(vm: HomeScreenViewModel, navController: NavController) {

    val notes by vm.notes.observeAsState(mutableListOf())

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Notes")
                },
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                navController.navigate(NavigationScreen.AddScreen.screenName)
            }) {
                Icon(Icons.Default.Add, "Add note", tint = Color.White)
            }
        }
    ) {
        if (notes.isNotEmpty())
            NoteList(notes, noteClicked = { note, index ->
                navController.currentBackStackEntry?.arguments = Bundle().apply {
                    putParcelable(ParcelableKeys.Note.name, note)
                    putInt(ParcelableKeys.NoteIndex.name, index)
                }
                navController.navigate(NavigationScreen.DetailScreen.screenName)
            })
        else
            EmptyScreen()
    }
}

@Composable
fun EmptyScreen() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Icon(
            Icons.Default.Help,
            contentDescription = "No notes added",
            modifier = Modifier
                .size(50.dp)
                .padding(bottom = 10.dp)
        )
        Text("No notes added")
    }
}

@Composable
fun NoteList(
    notes: List<Note>,
    noteClicked: (Note, Int) -> Unit
) {
    LazyColumn(modifier = Modifier.padding(16.dp)) {
        items(count = notes.size) { index ->
            val note = notes[index]
            Column(modifier = Modifier.clickable {
                noteClicked(note, index)
            }) {
                Text(
                    note.title,
                    modifier = Modifier.padding(
                        start = 10.dp,
                        top = 15.dp,
                        bottom = 15.dp
                    )
                )
                Divider()
            }
        }
    }
}