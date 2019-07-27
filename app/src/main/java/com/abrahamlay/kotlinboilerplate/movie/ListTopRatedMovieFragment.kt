package com.abrahamlay.kotlinboilerplate.movie

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Toast
import com.abrahamlay.common.base.BaseListFragment
import com.abrahamlay.common.constants.Constants
import com.abrahamlay.domain.entities.MovieModel
import com.abrahamlay.kotlinboilerplate.detail.DetailActivity
import javax.inject.Inject

/**
 * Created by abraham.lay01 on 7/26/2019.
 */
class ListTopRatedMovieFragment : BaseListFragment(), MovieContract.MoviesView, MovieAdapter.OnClickListener {
    @Inject
    lateinit var presenter: ListTopRatedMoviePresenter


    override fun loadData() {
        showProgressBar(true)
        presenter.getTopRatedMovies()
    }

    override fun getLayoutManager(): RecyclerView.LayoutManager? {
        return GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.view = this
        loadData()
    }

    override fun onRefresh() {
        loadData()
    }

    override fun onSuccess(data: List<MovieModel>) {
        showProgressBar(false)
        mItemList = data
        adapter = MovieAdapter(mItemList!!, this)
        getRecyclerView().adapter = adapter
    }

    override fun onFailed(message: String) {
        showProgressBar(false)
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    override fun onItemClicked(data: Any) {
        val item = data as MovieModel
        startActivity(
            Intent(activity, DetailActivity::class.java)
                .putExtra(Constants.PARAM_RESULT_ITEM, item)
        )
    }

}