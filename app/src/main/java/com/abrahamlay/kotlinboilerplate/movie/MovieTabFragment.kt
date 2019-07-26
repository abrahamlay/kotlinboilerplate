package com.abrahamlay.kotlinboilerplate.movie

import com.abrahamlay.common.base.tab.BaseTabFragment
import com.abrahamlay.kotlinboilerplate.R

/**
 * Created by abraham.lay01 on 7/26/2019.
 */
class MovieTabFragment : BaseTabFragment() {
    override fun initFragmentAndTitle() {
        titles.add(getString(R.string.popular))
        titles.add(getString(R.string.top_rated))
        titles.add(getString(R.string.favorite))
        fragments.add(ListMovieFragment())
        fragments.add(ListMovieFragment())
        fragments.add(ListMovieFragment())
    }
}