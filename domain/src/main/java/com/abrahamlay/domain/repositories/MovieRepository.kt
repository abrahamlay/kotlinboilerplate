package com.abrahamlay.domain.repositories

import com.abrahamlay.domain.entities.MovieModel
import io.reactivex.Flowable

/**
 * Created by abraham.lay01 on 7/25/2019.
 */
interface MovieRepository {
    fun getPopularMovies(apiKey: String): Flowable<List<MovieModel>>
    fun getTopRatedMovies(apiKey: String): Flowable<List<MovieModel>>
}