package com.abrahamlay.common.base.tab

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.abrahamlay.common.R
import com.abrahamlay.common.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_tab.*
import java.util.*

/**
 * Created by abraham.lay01 on 7/26/2019.
 */
abstract class BaseTabFragment : BaseFragment() {


    private var adapter: TabAdapter? = null
    protected lateinit var titles: ArrayList<String>
    protected lateinit var fragments: ArrayList<Fragment>
    protected abstract fun initFragmentAndTitle()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_tab, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        fragments = ArrayList()
        titles = ArrayList()

        initFragmentAndTitle()
        initTabAndPager()
    }

    private fun initTabAndPager() {
        if (isAdded) {
            adapter = TabAdapter(fragments, titles, childFragmentManager)
            pager.adapter = adapter
            tab.setupWithViewPager(pager)
            pager.offscreenPageLimit = fragments.size
        }
    }

}