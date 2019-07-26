package com.abrahamlay.kotlinboilerplate.di

import android.app.Application
import android.content.Context
import com.abrahamlay.common.base.UIThread
import com.abrahamlay.domain.PostExecutionThread
import dagger.Module
import dagger.Provides

import javax.inject.Singleton

@Module
class AppModule{
    @Provides
    @Singleton
    internal fun provideContext(application: Application): Context = application

    @Provides
    @Singleton
    fun providePostExecutionThread(uiThread: UIThread): PostExecutionThread = uiThread
}