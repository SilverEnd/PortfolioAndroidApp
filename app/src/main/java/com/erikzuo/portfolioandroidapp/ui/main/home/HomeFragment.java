package com.erikzuo.portfolioandroidapp.ui.main.home;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;

import com.erikzuo.portfolioandroidapp.databinding.FragmenHomeBinding;
import com.erikzuo.portfolioandroidapp.ui.base.BaseFragment;
import com.erikzuo.portfolioandroidapp.viewmodel.ViewModelProviderFactory;

import javax.inject.Inject;

/**
 * Created by YifanZuo on 5/2/18.
 */

public class HomeFragment extends BaseFragment<FragmenHomeBinding, HomeViewModel> implements HomeNavigator {

    @Inject
    ViewModelProviderFactory mFactory;

    private HomeViewModel mViewModel;

    @Override
    public HomeViewModel getViewModel() {
        mViewModel = ViewModelProviders.of(this, mFactory).get(HomeViewModel.class);

        return mViewModel;
    }

    @Override
    public int getBindingVariable() {
        return 0;
    }

    @Override
    public int getLayoutId() {
        return 0;
    }

    @Override
    public int getTitleId() {
        return 0;
    }

    @Override
    public int getIconId() {
        return 0;
    }
}
