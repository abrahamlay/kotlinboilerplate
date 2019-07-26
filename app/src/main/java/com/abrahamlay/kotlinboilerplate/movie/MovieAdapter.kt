package com.abrahamlay.kotlinboilerplate.movie

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.abrahamlay.domain.entities.MovieModel
import com.abrahamlay.kotlinboilerplate.R

/**
 * Created by abraham.lay01 on 7/26/2019.
 */
class MovieAdapter(private val data: List<MovieModel>,
                   private val onClickListener: OnClickListener) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(viewGroup: ViewGroup, pos: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(viewGroup.context)
        return MovieItemViewHolder(inflater.inflate(R.layout.item_movie,viewGroup,false))
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, pos: Int) {
        (viewHolder as MovieItemViewHolder).bindData(data[pos])
        (viewHolder as MovieItemViewHolder).setOnClickListener(View.OnClickListener { onClickListener.onItemClicked(data[pos]) })
    }

    interface OnClickListener{
        fun onItemClicked(data : Any)
    }
}