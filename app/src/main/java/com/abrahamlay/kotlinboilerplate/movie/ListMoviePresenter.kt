package com.abrahamlay.kotlinboilerplate.movie

import com.abrahamlay.common.base.BasePresenter
import com.abrahamlay.common.constants.Constants
import com.abrahamlay.domain.DefaultSubscriber
import com.abrahamlay.domain.entities.MovieModel
import com.abrahamlay.domain.interactors.GetMovies
import javax.inject.Inject

/**
 * Created by abraham.lay01 on 7/25/2019.
 */
class ListMoviePresenter @Inject constructor(private val getMovies: GetMovies) : BasePresenter {
    lateinit var view: MovieContract.MoviesView


    override fun resume() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun pause() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun destroy() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
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

    fun getMovies() {
        getMovies.execute(Subscriber(), GetMovies.Params(Constants.API_KEY))
    }
}