package com.erikzuo.portfolioandroidapp.ui.main.work;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.erikzuo.portfolioandroidapp.ui.main.work.industry.IndustryWorkFragment;
import com.erikzuo.portfolioandroidapp.ui.main.work.personal.PersonalWorkFragment;

/**
 * Created by Soprano on 7/02/2018.
 */

public class WorkPagerAdapter extends FragmentStatePagerAdapter {
    public Fragment[] mPages = new Fragment[]{
            IndustryWorkFragment.newInstance(),
            PersonalWorkFragment.newInstance()
    };


    public WorkPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return mPages[position];
    }

    @Override
    public int getCount() {
        return mPages.length;
    }
}
