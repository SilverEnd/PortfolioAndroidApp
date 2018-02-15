package com.erikzuo.portfolioandroidapp.ui.main.work

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter

import com.erikzuo.portfolioandroidapp.ui.main.work.industry.IndustryWorkFragment
import com.erikzuo.portfolioandroidapp.ui.main.work.personal.PersonalWorkFragment

/**
 * Created by YifanZuo on 7/02/2018.
 */

class WorkPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {
    var mPages = arrayOf<Fragment>(IndustryWorkFragment.newInstance(), PersonalWorkFragment.newInstance())

    override fun getItem(position: Int): Fragment {
        return mPages[position]
    }

    override fun getCount(): Int {
        return mPages.size
    }
}
