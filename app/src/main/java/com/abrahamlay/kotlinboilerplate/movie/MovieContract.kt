package com.abrahamlay.kotlinboilerplate.movie

import com.abrahamlay.domain.entities.MovieModel


/**
 * Created by Iffan Majid on 18/12/2018.
 */
class MovieContract {
    interface MoviesView {
        fun onSuccess(data: List<MovieModel>)
        fun onFailed(message: String)
    }
}