package com.abrahamlay.kotlinboilerplate

import android.app.Activity
import android.app.Application
import androidx.fragment.app.Fragment
import com.abrahamlay.kotlinboilerplate.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

class AndroidApp: Application(), HasActivityInjector, HasSupportFragmentInjector{

    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    @Inject
    lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>

    override fun activityInjector(): AndroidInjector<Activity> = this.activityInjector
    override fun supportFragmentInjector(): AndroidInjector<Fragment> = this.fragmentInjector

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.builder()
                .application(this)
                .build()
                .inject(this)
    }
}