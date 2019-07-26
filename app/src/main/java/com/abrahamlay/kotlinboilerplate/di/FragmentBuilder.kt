package com.abrahamlay.kotlinboilerplate.di

import com.abrahamlay.kotlinboilerplate.movie.ListMovieFragment
import com.abrahamlay.kotlinboilerplate.movie.MovieModule
import com.abrahamlay.kotlinboilerplate.movie.MovieTabFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilder {
    @ContributesAndroidInjector(modules = [(MovieModule::class)])
    abstract fun bindListMovieFragment(): ListMovieFragment

    @ContributesAndroidInjector(modules = [(MovieModule::class)])
    abstract fun bindMovieTabFragment(): MovieTabFragment
}