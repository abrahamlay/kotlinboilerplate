package com.abrahamlay.kotlinboilerplate.movie

import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import com.abrahamlay.common.base.BaseListFragment
import com.abrahamlay.common.constants.Constants
import com.abrahamlay.domain.entities.MovieModel
import com.abrahamlay.kotlinboilerplate.detail.DetailActivity
import com.abrahamlay.kotlinboilerplate.localdb.MovieDatabase

/**
 * Created by abraham.lay01 on 7/27/2019.
 */

class FavoriteMovieFragment : BaseListFragment(), MovieContract.MoviesView, MovieAdapter.OnClickListener {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
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
        showEmpty(message)
    }

    override fun loadData() {
        showProgressBar(true)
        mItemList = MovieDatabase.getAll(context!!)
        if (mItemList!!.isNullOrEmpty()){
            onFailed("Tidak ada film favorite")
        }else onSuccess(mItemList!!)
    }

    override fun getLayoutManager(): RecyclerView.LayoutManager? {
        return GridLayoutManager(
            context,
            2,
            GridLayoutManager.VERTICAL,
            false
        )
    }

    override fun onItemClicked(data: Any) {
        val item = data as MovieModel
        startActivity(
            Intent(activity, DetailActivity::class.java)
                .putExtra(Constants.PARAM_RESULT_ITEM, item)
        )
    }

}