package com.abrahamlay.common.base

/**
 * Created by abraham.lay01 on 7/26/2019.
 */
interface BaseView {
    fun onUnknownError(code: Int, errorMessage: String)

    fun onTimeout()

    fun onNetworkError()

    fun showEmpty(message: String?)
}