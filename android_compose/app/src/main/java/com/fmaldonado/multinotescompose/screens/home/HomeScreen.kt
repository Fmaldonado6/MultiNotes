package com.fmaldonado.multinotescompose.screens.home

import androidx.compose.foundation.layout.*
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
            NoteList(notes)
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
fun NoteList(notes: List<Note>) {

}