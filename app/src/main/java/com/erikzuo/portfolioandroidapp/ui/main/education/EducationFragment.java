package com.erikzuo.portfolioandroidapp.ui.main.education;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;

import com.erikzuo.portfolioandroidapp.BR;
import com.erikzuo.portfolioandroidapp.R;
import com.erikzuo.portfolioandroidapp.databinding.FragmentEducationBinding;
import com.erikzuo.portfolioandroidapp.ui.base.BaseFragment;
import com.erikzuo.portfolioandroidapp.viewmodel.ViewModelProviderFactory;

import javax.inject.Inject;

/**
 * Created by Soprano on 9/02/2018.
 */

public class EducationFragment extends BaseFragment<FragmentEducationBinding, EducationViewModel> {

    @Inject
    ViewModelProviderFactory mFactory;

    @Inject
    EducationAdapter mAdapter;

    @Inject
    LinearLayoutManager mLayoutManager;



    private EducationViewModel mViewModel;


    public static EducationFragment newInstance() {
        Bundle args = new Bundle();
        EducationFragment fragment = new EducationFragment();
        fragment.setArguments(args);
        return fragment;
    }



    @Override
    public int getLayoutId() {
        return R.layout.fragment_education;
    }

    @Override
    public EducationViewModel getViewModel() {
        mViewModel = ViewModelProviders.of(this, mFactory).get(EducationViewModel.class);

        return mViewModel;
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public void initViews() {
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        getViewDataBinding().list.setLayoutManager(mLayoutManager);
        getViewDataBinding().list.setItemAnimator(new DefaultItemAnimator());
        getViewDataBinding().list.setAdapter(mAdapter);
    }
}
