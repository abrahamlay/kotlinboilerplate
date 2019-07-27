package com.abrahamlay.kotlinboilerplate

import com.abrahamlay.common.base.BasePresenter
import com.abrahamlay.kotlinboilerplate.movie.ListPopularMoviePresenter
import com.abrahamlay.kotlinboilerplate.movie.ListTopRatedMoviePresenter
import dagger.Module
import dagger.Provides

/**
 * Created by abraham.lay01 on 7/25/2019.
 */

@Module
class MovieModule {
    @Provides
    fun provListTopRatedMoviePresenter(presenterPopular: ListTopRatedMoviePresenter): BasePresenter = presenterPopular

    @Provides
    fun provListPopularMoviePresenter(presenterPopular: ListPopularMoviePresenter): BasePresenter = presenterPopular
}