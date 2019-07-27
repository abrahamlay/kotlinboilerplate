package com.abrahamlay.kotlinboilerplate.detail

import android.os.Bundle

import com.abrahamlay.common.base.BaseActivity
import com.abrahamlay.common.constants.Constants
import com.abrahamlay.common.constants.Constants.Companion.MOVIE_THUMBNAIL_BASE_URL_EXTRA_LARGE
import com.abrahamlay.common.util.DateFormater
import com.abrahamlay.common.util.GlideHelper
import com.abrahamlay.domain.entities.MovieModel
import com.abrahamlay.kotlinboilerplate.R
import kotlinx.android.synthetic.main.activity_detail.*

/**
 * Created by abraham.lay01 on 7/26/2019.
 */
class DetailActivity : BaseActivity() {


    private lateinit var detail: MovieModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detail = intent.getSerializableExtra(Constants.PARAM_RESULT_ITEM) as MovieModel
        setContentView(R.layout.activity_detail)
        initToolbar()
    }

    private fun initToolbar() {
        val url = String.format(MOVIE_THUMBNAIL_BASE_URL_EXTRA_LARGE, detail.posterPath)
        GlideHelper.showImage(url, backdropMovie, this)
        setSupportActionBar(toolbar)
        supportActionBar.let {
            supportActionBar?.title = detail.title
            val releaseDate =
                DateFormater.changeDateFormat("yyyy-MM-dd", detail.releaseDate, "EEEE,  MMM dd, yyyy")
            supportActionBar?.subtitle = releaseDate
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }

        initDetail()
    }

    private fun initDetail() {
        replaceFragment(R.id.container, DetailFragment.newInstance(detail), false)
    }

}