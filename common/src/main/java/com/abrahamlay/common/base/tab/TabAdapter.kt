package com.abrahamlay.common.base.tab

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter

/**
 * Created by abraham.lay01 on 7/26/2019.
 */
class TabAdapter(private val items :List<Fragment> , private val titles : List<String> ,fm: FragmentManager?) : FragmentStatePagerAdapter(fm) {
    override fun getItem(pos: Int): Fragment {
        return items[pos]
    }

    override fun getCount(): Int {
        return items.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return titles[position]
    }
}