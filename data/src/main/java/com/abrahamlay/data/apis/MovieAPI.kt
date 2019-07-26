package com.abrahamlay.data.apis

import com.abrahamlay.data.responses.MovieResponse
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by abraham.lay01 on 7/25/2019.
 */
interface MovieAPI{
    @GET("3/discover/movie")
    fun getMovies(@Query("api_key") apiKey: String): Flowable<MovieResponse>
}