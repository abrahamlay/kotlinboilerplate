package com.abrahamlay.kotlinboilerplate.movie

import com.abrahamlay.common.base.BasePresenter
import dagger.Module
import dagger.Provides

/**
 * Created by abraham.lay01 on 7/25/2019.
 */

@Module
class MovieModule {
    @Provides
    fun provListMoviewPresenter(presenter: ListMoviePresenter): BasePresenter = presenter
}