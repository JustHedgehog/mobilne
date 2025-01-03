package com.example.lab1.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.lab1.MovieRow
import com.example.lab1.navigation.MovieScreens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Movies TopAppBar")},
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Magenta
                ),
                modifier = Modifier.shadow(5.dp)
            )
        },
    ) { it ->
        Column(
            modifier = Modifier
                .padding(it)
        ) {
            MainContent(navController = navController)
        }
    }
}

@Composable
fun MainContent(navController: NavController,
                moviesList: List<String> = listOf(
                    "Avatar",
                    "555",
                    "Harry Potter",
                    "Life",
                    "Lolek",
                    "Bolek",
                    "Krecik"
                )){
    Column(modifier = Modifier.padding(12.dp)) {
        LazyColumn {
            items(items = moviesList){
                MovieRow(movie = it){movie -> navController.navigate(route = MovieScreens.DetailsScreen.name+"/$movie")}
            }
        }
    }
}