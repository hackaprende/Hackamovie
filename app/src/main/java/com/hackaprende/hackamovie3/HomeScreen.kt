package com.hackaprende.hackamovie3

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(movies: List<Movie>, onItemClicked: (Movie) -> Unit) {
    Scaffold {
        LazyColumn {
            items(movies) {
                MovieItem(movie = it, onItemClicked)
            }
        }
    }
}

@Composable
fun MovieItem(movie: Movie, onItemClicked: (Movie) -> Unit) {
    var movieSelectedState by remember { mutableStateOf(false) }

    Row(modifier = Modifier
        .background(color = if (movieSelectedState)
            Color.Black else
            Color.White)
    ) {
        Text(modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
            .clickable {
                movieSelectedState = !movie.isSelected
                onItemClicked(movie)
            },
            text = movie.title, color = if (movieSelectedState)
                Color.White else
                Color.Black)
    }
}