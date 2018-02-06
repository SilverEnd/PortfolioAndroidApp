package com.erikzuo.portfolioandroidapp.ui.main.home;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;

import com.erikzuo.portfolioandroidapp.BR;
import com.erikzuo.portfolioandroidapp.R;
import com.erikzuo.portfolioandroidapp.databinding.FragmenHomeBinding;
import com.erikzuo.portfolioandroidapp.ui.base.BaseFragment;
import com.erikzuo.portfolioandroidapp.ui.main.contact.ContactFragment;
import com.erikzuo.portfolioandroidapp.viewmodel.ViewModelProviderFactory;

import javax.inject.Inject;

/**
 * Created by YifanZuo on 5/2/18.
 */

public class HomeFragment extends BaseFragment<FragmenHomeBinding, HomeViewModel> implements HomeNavigator {
    public static final String TAG = "HomeFragment";

    @Inject
    ViewModelProviderFactory mFactory;

    private HomeViewModel mViewModel;


    public static HomeFragment newInstance() {
        Bundle args = new Bundle();
        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public HomeViewModel getViewModel() {
        mViewModel = ViewModelProviders.of(this, mFactory).get(HomeViewModel.class);

        return mViewModel;
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragmen_home;
    }

    @Override
    public void initViews() {

    }

}
