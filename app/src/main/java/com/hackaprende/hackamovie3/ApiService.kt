package com.hackaprende.hackamovie3

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private val retrofit = Retrofit.Builder()
    .baseUrl(Constants.BASE_URL)
    .addConverterFactory(MoshiConverterFactory.create())
    .build()

interface ApiService {
    @GET(Constants.POPULAR_MOVIES_URL)
    suspend fun getPopularMovies(): MovieJSONResponse
}

object MoviesApi {
    val retrofitService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}