package com.abrahamlay.common.util

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.request.RequestOptions

/**
 * Created by abraham.lay01 on 7/26/2019.
 */

object GlideHelper {
    fun showImage(url: String, imageView: ImageView, context: Context) {
        val options = RequestOptions()
            .centerCrop()
            .priority(Priority.HIGH)

        val requestBuilder = Glide.with(context)
            .load(url)
        requestBuilder
            .thumbnail(
                Glide.with(context)
                    .load(url)
            )
            .apply(options)
            .into(imageView)
    }
}
