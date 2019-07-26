package com.abrahamlay.kotlinboilerplate.di

import com.abrahamlay.data.ApiProvider
import com.abrahamlay.data.apis.MovieAPI
import dagger.Module
import dagger.Provides
import javax.inject.Inject

@Module
class ApiModule @Inject constructor() {

    @Provides
    fun provMovieApi(): MovieAPI = ApiProvider()
            .getRetrofit()
            .create(MovieAPI::class.java)
}