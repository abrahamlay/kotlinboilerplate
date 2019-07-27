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

class GetTopRatedMovies @Inject constructor(
    private val repository: MovieRepository,
    postExecutionThread: PostExecutionThread
) : UseCase<List<MovieModel>, GetTopRatedMovies.Params>(postExecutionThread) {
    override fun build(params: Params): Flowable<List<MovieModel>> = repository.getTopRatedMovies(params.apiKey)

    data class Params(val apiKey: String)
}