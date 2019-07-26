package com.abrahamlay.kotlinboilerplate.di

import com.abrahamlay.kotlinboilerplate.MainActivity
import com.abrahamlay.kotlinboilerplate.movie.MovieModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {
    @ContributesAndroidInjector(modules = [(MovieModule::class)])
    abstract fun bindMainActivity(): MainActivity
}