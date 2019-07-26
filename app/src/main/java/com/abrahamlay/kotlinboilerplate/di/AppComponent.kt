package com.abrahamlay.kotlinboilerplate.di

import android.app.Application
import com.abrahamlay.kotlinboilerplate.AndroidApp
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    (AndroidInjectionModule::class),
    (AppModule::class),
    (DataModule::class),
    (ActivityBuilder::class),
    (FragmentBuilder::class),
    (ApiModule::class)
])

interface AppComponent{
    @Component.Builder
    interface Builder{
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }

    fun inject(app: AndroidApp)
}