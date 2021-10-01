package com.hackaprende.hackamovie3

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    var movies: List<Movie> by mutableStateOf(listOf())
        private set

    private val repository = MovieRepository()

    init {
        downloadPopularMovies()
    }

    private fun downloadPopularMovies() {
        viewModelScope.launch {
            movies = repository.getMovies()
        }
    }

    fun onMovieSelected(movie: Movie) {
        val myMovies = mutableListOf<Movie>()
        myMovies.addAll(movies)

        for (myMovie in myMovies) {
            if (myMovie.id == movie.id) {
                myMovie.isSelected = !myMovie.isSelected
            }
        }

        movies = myMovies
    }
}