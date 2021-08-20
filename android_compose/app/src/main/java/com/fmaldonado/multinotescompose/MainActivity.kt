package com.fmaldonado.multinotescompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.fmaldonado.multinotescompose.screens.home.HomeScreen
import com.fmaldonado.multinotescompose.screens.home.HomeScreenViewModel
import com.fmaldonado.multinotescompose.ui.theme.MultiNotesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MultiNotesTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Navigation()
                }
            }
        }
    }

    @Composable
    private fun Navigation() {
        val navController = rememberNavController()
        NavHost(
            navController = navController,
            startDestination = NavigationScreen.HomeScreen.screenName,
            builder = {
                composable(NavigationScreen.HomeScreen.screenName) {
                    val viewModel: HomeScreenViewModel by viewModels()
                    HomeScreen(viewModel)
                }
            }
        )
    }
}

enum class NavigationScreen(val screenName: String) {
    HomeScreen("home")
}