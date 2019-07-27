package com.abrahamlay.kotlinboilerplate.di

import com.abrahamlay.kotlinboilerplate.MovieModule
import com.abrahamlay.kotlinboilerplate.detail.DetailFragment
import com.abrahamlay.kotlinboilerplate.main.MovieTabFragment
import com.abrahamlay.kotlinboilerplate.movie.FavoriteMovieFragment
import com.abrahamlay.kotlinboilerplate.movie.ListPopularMovieFragment
import com.abrahamlay.kotlinboilerplate.movie.ListTopRatedMovieFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilder {
    @ContributesAndroidInjector(modules = [(MovieModule::class)])
    abstract fun bindListPopularMovieFragment(): ListPopularMovieFragment

    @ContributesAndroidInjector(modules = [(MovieModule::class)])
    abstract fun bindListTopRatedMovieFragment(): ListTopRatedMovieFragment

    @ContributesAndroidInjector(modules = [(MovieModule::class)])
    abstract fun bindMovieTabFragment(): MovieTabFragment

    @ContributesAndroidInjector(modules = [(MovieModule::class)])
    abstract fun bindDetailFragment(): DetailFragment

    @ContributesAndroidInjector(modules = [(MovieModule::class)])
    abstract fun bindFavoriteMovieFragment(): FavoriteMovieFragment
}