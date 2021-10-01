package com.hackaprende.hackamovie3

object Constants {
    // TODO - Put this API KEY constant in an ignored file for security
    private const val BACKEND_API_KEY = "bbb62d335a89942736cb4d7c2e40d1cc"
    private const val API_KEY_URL_FORMAT = "?api_key=$BACKEND_API_KEY"

    const val BASE_URL = "https://api.themoviedb.org/3/"
    const val POPULAR_MOVIES_URL = "movie/popular$API_KEY_URL_FORMAT"
}
