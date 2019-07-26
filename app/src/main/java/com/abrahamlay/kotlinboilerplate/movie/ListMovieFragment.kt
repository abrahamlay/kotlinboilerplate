package com.abrahamlay.kotlinboilerplate.movie

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Toast
import com.abrahamlay.common.base.BaseListFragment
import com.abrahamlay.domain.entities.MovieModel
import javax.inject.Inject

/**
 * Created by abraham.lay01 on 7/26/2019.
 */
class ListMovieFragment : BaseListFragment(), MovieContract.MoviesView, MovieAdapter.OnClickListener {
    @Inject
    lateinit var presenter: ListMoviePresenter


    override fun loadData() {
        showProgressBar(true)
        presenter.getMovies()
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
        Toast.makeText(context, (data as MovieModel).title, Toast.LENGTH_SHORT).show()
    }

}