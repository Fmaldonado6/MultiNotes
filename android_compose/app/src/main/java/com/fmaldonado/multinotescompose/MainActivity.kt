package com.fmaldonado.multinotescompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.*
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.fmaldonado.multinotescompose.screens.add.AddScreen
import com.fmaldonado.multinotescompose.screens.add.AddScreenViewModel
import com.fmaldonado.multinotescompose.screens.home.HomeScreen
import com.fmaldonado.multinotescompose.screens.home.HomeScreenViewModel
import com.fmaldonado.multinotescompose.ui.theme.MultiNotesTheme
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.google.accompanist.navigation.animation.navigation
import com.google.accompanist.navigation.animation.composable

class MainActivity : ComponentActivity() {
    @ExperimentalAnimationApi
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

    @ExperimentalAnimationApi
    @Composable
    private fun Navigation() {
        val navController = rememberAnimatedNavController()
        AnimatedNavHost(
            navController = navController,
            startDestination = NavigationScreen.HomeScreen.screenName,
            builder = {
                composable(
                    NavigationScreen.HomeScreen.screenName,
                    exitTransition = { _, _ -> exitAnimation() },
                    popEnterTransition = { _, _ -> popEnterAnimation() }
                ) {
                    val viewModel: HomeScreenViewModel by viewModels()
                    HomeScreen(viewModel, navController)
                }
                composable(
                    NavigationScreen.AddScreen.screenName,
                    enterTransition = { _, _ -> enterAnimation() },
                    popExitTransition = { _, _ -> popExittAnimation() }
                ) {
                    val viewModel: AddScreenViewModel by viewModels()
                    AddScreen(navController = navController, viewModel = viewModel)
                }
            }
        )
    }

    @ExperimentalAnimationApi
    fun enterAnimation(): EnterTransition {
        return slideInVertically(
            initialOffsetY = { 300 },
            animationSpec = tween(300, easing = FastOutSlowInEasing)
        ) + fadeIn(animationSpec = tween(300))
    }

    @ExperimentalAnimationApi
    fun exitAnimation(): ExitTransition {
        return fadeOut(animationSpec = tween(300))
    }

    @ExperimentalAnimationApi
    fun popExittAnimation(): ExitTransition {
        return slideOutVertically(
            animationSpec = tween(300),
            targetOffsetY = { 300 }) + fadeOut(
            animationSpec = tween(
                300
            )
        )
    }

    @ExperimentalAnimationApi
    fun popEnterAnimation(): EnterTransition {
        return fadeIn(animationSpec = tween(300))
    }
}

enum class NavigationScreen(val screenName: String) {
    HomeScreen("home"),
    AddScreen("add")
}