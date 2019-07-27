package com.abrahamlay.kotlinboilerplate.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.abrahamlay.common.base.BaseActivity
import com.abrahamlay.kotlinboilerplate.R

class MainActivity : BaseActivity() {


    companion object {
        fun getStartIntent(context: Context) {
            val intent = Intent(context, MainActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        replaceFragment(R.id.container, MovieTabFragment(), false)
    }
}
