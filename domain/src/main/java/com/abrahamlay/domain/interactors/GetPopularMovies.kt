package com.abrahamlay.domain.interactors

import com.abrahamlay.domain.PostExecutionThread
import com.abrahamlay.domain.UseCase
import com.abrahamlay.domain.entities.MovieModel
import com.abrahamlay.domain.repositories.MovieRepository
import io.reactivex.Flowable
import javax.inject.Inject


/**
 * Created by abraham.lay01 on 7/25/2019.
 */

class GetPopularMovies @Inject constructor(
    private val repository: MovieRepository,
    postExecutionThread: PostExecutionThread
) : UseCase<List<MovieModel>, GetPopularMovies.Params>(postExecutionThread) {
    override fun build(params: Params): Flowable<List<MovieModel>> = repository.getPopularMovies(params.apiKey)

    data class Params(val apiKey: String)
}