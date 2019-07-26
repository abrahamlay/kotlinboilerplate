package com.abrahamlay.kotlinboilerplate.di

import com.abrahamlay.data.repositoryimpl.MovieRepositoryImpl
import com.abrahamlay.domain.repositories.MovieRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataModule {

    @Provides
    @Singleton
    fun provMovieData(impl: MovieRepositoryImpl): MovieRepository = impl
}