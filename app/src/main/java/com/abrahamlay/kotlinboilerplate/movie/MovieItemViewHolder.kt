package com.abrahamlay.kotlinboilerplate.movie

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.abrahamlay.common.constants.Constants.Companion.MOVIE_THUMBNAIL_BASE_URL_LARGE
import com.abrahamlay.common.util.DateFormater
import com.abrahamlay.common.util.GlideHelper
import com.abrahamlay.domain.entities.MovieModel
import kotlinx.android.synthetic.main.item_movie.view.*

/**
 * Created by abraham.lay01 on 7/26/2019.
 */
class MovieItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val tvReleaseDate: TextView = itemView.tvReleaseDate
    private val tvDesc: TextView = itemView.tvDesc
    private val ivMovie: ImageView = itemView.ivMovie
    private val tvTitle: TextView = itemView.tvTitle

    fun bindData(item: MovieModel) {
        val url = String.format(MOVIE_THUMBNAIL_BASE_URL_LARGE, item.backdropPath)
        tvTitle.text = item.title

        GlideHelper.showImage(url, ivMovie, itemView.context)
        tvDesc.text = item.overview

        val releaseDate = DateFormater.changeDateFormat("yyyy-MM-dd", item.releaseDate, "EEEE,  MMM dd, yyyy")
        tvReleaseDate.text = releaseDate
    }

    fun setOnClickListener(listener: View.OnClickListener) {
        itemView.setOnClickListener(listener)
    }
}