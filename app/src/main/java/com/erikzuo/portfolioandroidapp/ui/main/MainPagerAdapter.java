package com.erikzuo.portfolioandroidapp.ui.main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.erikzuo.portfolioandroidapp.ui.base.BaseFragment;
import com.erikzuo.portfolioandroidapp.ui.main.Contact.ContactFragment;

/**
 * Created by Soprano on 5/02/2018.
 */

public class MainPagerAdapter extends FragmentStatePagerAdapter {
    public BaseFragment[] mPages = new BaseFragment[]{
            ContactFragment.newInstance(),
            ContactFragment.newInstance(),
            ContactFragment.newInstance(),
            ContactFragment.newInstance()
    };


    public MainPagerAdapter(FragmentManager fm) {
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
