package com.hackaprende.hackamovie3

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MovieRepository {

    suspend fun getMovies(): List<Movie> {
        return withContext(Dispatchers.IO) {
            val movieJSONResponse = MoviesApi.retrofitService.getPopularMovies()

            movieJSONResponse.results
        }
    }
}