package com.abrahamlay.data.apis

import com.abrahamlay.data.responses.MovieResponse
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by abraham.lay01 on 7/25/2019.
 */
interface MovieAPI {
    @GET("3/movie/popular")
    fun getPopularMovies(@Query("api_key") apiKey: String): Flowable<MovieResponse>

    @GET("3/movie/top_rated")
    fun getTopRatedMovies(@Query("api_key") apiKey: String): Flowable<MovieResponse>

}