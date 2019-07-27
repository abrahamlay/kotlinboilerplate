package com.abrahamlay.common.base

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import dagger.android.support.AndroidSupportInjection

/**
 * Created by abraham.lay01 on 7/26/2019.
 */
@SuppressLint("Registered")
open class BaseFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidSupportInjection.inject(this)
    }

}