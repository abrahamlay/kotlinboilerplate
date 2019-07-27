package com.abrahamlay.kotlinboilerplate.di

import com.abrahamlay.kotlinboilerplate.MovieModule
import com.abrahamlay.kotlinboilerplate.detail.DetailActivity
import com.abrahamlay.kotlinboilerplate.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {
    @ContributesAndroidInjector(modules = [(MovieModule::class)])
    abstract fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector(modules = [(MovieModule::class)])
    abstract fun bindDetailActivity(): DetailActivity
}