package id.my.suryadev.movieapp

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import id.my.suryadev.movieapp.screens.HomeScreen
import id.my.suryadev.movieapp.screens.ReviewScreen
import id.my.suryadev.movieapp.screens.SearchScreen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Preview
@Composable
fun App() {
    val selectedRoute = remember { mutableStateOf("home") }
    Scaffold(
        bottomBar = {
            BottomNavbar(
                selectedRoute = selectedRoute.value,
                onChange = { route -> selectedRoute.value = route }
            )
        },
        modifier = Modifier.background(color = Color(0xFF0A0B0B)),
        content = {
            when (selectedRoute.value) {
                Routes.HomePage.route -> HomeScreen()
                Routes.SearchPage.route -> SearchScreen()
                Routes.ReviewPage.route -> ReviewScreen()
            }
        }
    )
}