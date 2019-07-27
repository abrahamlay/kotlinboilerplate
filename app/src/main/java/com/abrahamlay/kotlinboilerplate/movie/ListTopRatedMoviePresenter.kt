package com.abrahamlay.kotlinboilerplate.movie

import com.abrahamlay.common.base.BasePresenter
import com.abrahamlay.common.constants.Constants
import com.abrahamlay.domain.DefaultSubscriber
import com.abrahamlay.domain.entities.MovieModel
import com.abrahamlay.domain.interactors.GetTopRatedMovies
import javax.inject.Inject

/**
 * Created by abraham.lay01 on 7/25/2019.
 */
class ListTopRatedMoviePresenter @Inject constructor(private val getTopRatedMovies: GetTopRatedMovies) : BasePresenter {
    lateinit var view: MovieContract.MoviesView


    override fun resume() {

    }

    override fun pause() {

    }

    override fun destroy() {

    }

    inner class Subscriber : DefaultSubscriber<List<MovieModel>>() {
        override fun onNext(data: List<MovieModel>) {
            super.onNext(data)
            view.onSuccess(data)
        }

        override fun onError(error: Throwable?) {
            super.onError(error)
            view.onFailed(error!!.message!!)
        }
    }

    fun getTopRatedMovies() {
        getTopRatedMovies.execute(Subscriber(), GetTopRatedMovies.Params(Constants.API_KEY))
    }
}