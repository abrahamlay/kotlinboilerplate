package com.abrahamlay.common.base.widget

/**
 * Created by abraham.lay01 on 7/26/2019.
 */

import android.text.Spanned
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.abrahamlay.common.R

/**
 * Created by abrahamlay on 17/08/2018.
 */

class EmptyViewHolder(private val rootView: View) {
    private val tvMessage: TextView = rootView.findViewById(R.id.tv_message)
    private val icon: ImageView = rootView.findViewById(R.id.iv_empty)

    fun showOnNetworkError() {
        show()
        setMessage(R.string.network_error)
    }

    fun showOnTimeout() {
        show()
        setMessage(R.string.timeout_error)
    }

    fun setEmptyResult() {
        show()
        setMessage(R.string.movie_cant_be_found)
    }

    fun setMessage(text: String?) {
        if (text != null) tvMessage.text = text
    }

    fun setMessage(text: Spanned?): EmptyViewHolder {
        if (text != null) tvMessage.text = text
        return this
    }

    private fun setMessage(textResId: Int) {
        tvMessage.setText(textResId)
    }

    fun setIcon(iconResId: Int): EmptyViewHolder {
        if (iconResId != 0) {
            icon.visibility = View.VISIBLE
            icon.setImageResource(iconResId)
        }

        return this
    }

    fun showIcon(show: Boolean): EmptyViewHolder {
        icon.visibility = if (show) View.VISIBLE else View.GONE
        return this
    }

    fun hide() {
        rootView.visibility = View.GONE
    }

    fun show() {
        rootView.visibility = View.VISIBLE
    }

}
