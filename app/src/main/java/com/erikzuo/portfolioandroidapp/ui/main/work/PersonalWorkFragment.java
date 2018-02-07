package com.erikzuo.portfolioandroidapp.ui.main.work;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;

import com.erikzuo.portfolioandroidapp.BR;
import com.erikzuo.portfolioandroidapp.R;
import com.erikzuo.portfolioandroidapp.databinding.FragmentPersonalWorkBinding;
import com.erikzuo.portfolioandroidapp.ui.base.BaseFragment;
import com.erikzuo.portfolioandroidapp.viewmodel.ViewModelProviderFactory;

import javax.inject.Inject;

/**
 * Created by Soprano on 7/02/2018.
 */

public class PersonalWorkFragment extends BaseFragment<FragmentPersonalWorkBinding, WorkViewModel> {

    @Inject
    ViewModelProviderFactory mFactory;

    private WorkViewModel mViewModel;


    public static PersonalWorkFragment newInstance() {
        Bundle args = new Bundle();
        PersonalWorkFragment fragment = new PersonalWorkFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_personal_work;
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

    }
}
