package com.abrahamlay.common.base

import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.abrahamlay.common.R
import com.abrahamlay.common.base.widget.EmptyViewHolder
import com.abrahamlay.domain.entities.MovieModel
import kotlinx.android.synthetic.main.fragment_list.*
import java.net.HttpURLConnection

/**
 * Created by abraham.lay01 on 7/26/2019.
 */
abstract class BaseListFragment : BaseFragment(), BaseView, SwipeRefreshLayout.OnRefreshListener {

    private lateinit var emptyViewHolder: EmptyViewHolder
    protected var adapter: RecyclerView.Adapter<RecyclerView.ViewHolder>? = null

    protected abstract fun loadData()

    protected var mItemList: List<MovieModel>? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        emptyViewHolder = EmptyViewHolder(emptyView)
    }


    override fun onRefresh() {
        initState()
        loadData()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initState()
        refresh.setOnRefreshListener(this)

    }

    protected fun getRecyclerView(): RecyclerView {
        return rvList
    }

    protected fun initState() {
        adapter = null
        emptyViewHolder.hide()
        rvList.layoutManager = getLayoutManager()
    }

    abstract fun getLayoutManager(): RecyclerView.LayoutManager?

    open fun showProgressBar(active: Boolean) {
        if (isAdded) {
            progressBarView.let { progressBarView.visibility = if (active) View.VISIBLE else View.GONE }
            refresh.let { refresh.isRefreshing = active }
        }
    }

    override fun showEmpty(message: String?) {
        if (isAdded) {
            setEmptyRvList()
            emptyViewHolder.setMessage(message ?: getString(R.string.movie_cant_be_found))
        }
    }

    private fun setEmptyRvList() {
        rvList.visibility = View.GONE
        emptyViewHolder.show()
    }


    override fun onUnknownError(code: Int, errorMessage: String) {
        if (isAdded) {
            adapter?.notifyDataSetChanged()
            if (code == HttpURLConnection.HTTP_FORBIDDEN) {
                Toast.makeText(context, R.string.error_limit_request, Toast.LENGTH_LONG).show()
                return
            }
            Toast.makeText(context, errorMessage, Toast.LENGTH_LONG).show()
        }
    }

    override fun onTimeout() {
        if (isAdded) {
            Toast.makeText(context, R.string.timeout_error, Toast.LENGTH_LONG).show()
        }

    }

    override fun onNetworkError() {
        if (isAdded) {
            Toast.makeText(context, R.string.network_error, Toast.LENGTH_LONG).show()
        }
    }


}