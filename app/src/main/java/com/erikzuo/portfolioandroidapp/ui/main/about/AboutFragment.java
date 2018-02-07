package com.erikzuo.portfolioandroidapp.ui.main.about;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;

import com.erikzuo.portfolioandroidapp.BR;
import com.erikzuo.portfolioandroidapp.R;
import com.erikzuo.portfolioandroidapp.databinding.FragmentAboutBinding;
 import com.erikzuo.portfolioandroidapp.ui.base.BaseFragment;
import com.erikzuo.portfolioandroidapp.viewmodel.ViewModelProviderFactory;

import javax.inject.Inject;

/**
 * Created by YifanZuo on 4/2/18.
 */

public class AboutFragment extends BaseFragment<FragmentAboutBinding, AboutViewModel> implements AboutNavigator {

    @Inject
    ViewModelProviderFactory mFactory;

    private AboutViewModel mViewModel;

    public static AboutFragment newInstance() {
        Bundle args = new Bundle();
        AboutFragment fragment = new AboutFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public AboutViewModel getViewModel() {
        mViewModel = ViewModelProviders.of(this, mFactory).get(AboutViewModel.class);

        return mViewModel;
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_about;
    }

    @Override
    public void initViews() {

    }

}
