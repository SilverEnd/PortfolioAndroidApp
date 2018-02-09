package com.erikzuo.portfolioandroidapp.ui.main.work;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;

import com.erikzuo.portfolioandroidapp.BR;
import com.erikzuo.portfolioandroidapp.R;
import com.erikzuo.portfolioandroidapp.databinding.FragmentWorkBinding;
import com.erikzuo.portfolioandroidapp.ui.base.BaseFragment;
import com.erikzuo.portfolioandroidapp.ui.main.home.HomeFragment;
import com.erikzuo.portfolioandroidapp.viewmodel.ViewModelProviderFactory;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

/**
 * Created by Soprano on 7/02/2018.
 */

public class WorkFragment extends BaseFragment<FragmentWorkBinding, WorkViewModel> implements WorkNavigator, HasSupportFragmentInjector {

    @Inject
    ViewModelProviderFactory mFactory;

    @Inject
    WorkPagerAdapter mPageAdapter;

    @Inject
    DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector;


    private WorkViewModel mViewModel;

    public static WorkFragment newInstance() {
        Bundle args = new Bundle();
        WorkFragment fragment = new WorkFragment();
        fragment.setArguments(args);
        return fragment;
    }



    @Override
    public int getLayoutId() {
        return R.layout.fragment_work;
    }

    @Override
    public WorkViewModel getViewModel() {
        mViewModel = ViewModelProviders.of(this, mFactory).get(WorkViewModel.class);

        return mViewModel;
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public void initViews() {
        getViewDataBinding().tabLayout.addTab(getViewDataBinding().tabLayout.newTab().setText(R.string.industry_work).setIcon(R.drawable.ic_work));
        getViewDataBinding().tabLayout.addTab(getViewDataBinding().tabLayout.newTab().setText(R.string.personal_work).setIcon(R.drawable.ic_github));
        getViewDataBinding().tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                getViewDataBinding().pager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        getViewDataBinding().pager.setAdapter(mPageAdapter);
        getViewDataBinding().pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(getViewDataBinding().tabLayout));

    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return fragmentDispatchingAndroidInjector;
    }
}
