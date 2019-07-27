package com.abrahamlay.kotlinboilerplate.main

import com.abrahamlay.common.base.tab.BaseTabFragment
import com.abrahamlay.kotlinboilerplate.R
import com.abrahamlay.kotlinboilerplate.movie.FavoriteMovieFragment
import com.abrahamlay.kotlinboilerplate.movie.ListPopularMovieFragment
import com.abrahamlay.kotlinboilerplate.movie.ListTopRatedMovieFragment

/**
 * Created by abraham.lay01 on 7/26/2019.
 */
class MovieTabFragment : BaseTabFragment() {
    override fun initFragmentAndTitle() {
        titles.add(getString(R.string.popular))
        titles.add(getString(R.string.top_rated))
        titles.add(getString(R.string.favorite))
        fragments.add(ListPopularMovieFragment())
        fragments.add(ListTopRatedMovieFragment())
        fragments.add(FavoriteMovieFragment())
    }
}