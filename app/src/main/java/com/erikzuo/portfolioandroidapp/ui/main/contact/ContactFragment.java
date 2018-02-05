package com.erikzuo.portfolioandroidapp.ui.main.contact;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;

import com.erikzuo.portfolioandroidapp.R;
import com.erikzuo.portfolioandroidapp.databinding.FragmentContactBinding;
import com.erikzuo.portfolioandroidapp.ui.base.BaseFragment;
import com.erikzuo.portfolioandroidapp.viewmodel.ViewModelProviderFactory;

import javax.inject.Inject;

/**
 * Created by YifanZuo on 4/2/18.
 */

public class ContactFragment extends BaseFragment<FragmentContactBinding, ContactViewModel> implements ContactNavigator {

    @Inject
    ViewModelProviderFactory mFactory;

    private ContactViewModel mViewModel;

    public static ContactFragment newInstance() {
        Bundle args = new Bundle();
        ContactFragment fragment = new ContactFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public ContactViewModel getViewModel() {
        mViewModel = ViewModelProviders.of(this, mFactory).get(ContactViewModel.class);

        return mViewModel;
    }

    @Override
    public int getBindingVariable() {
        return 0;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_contact;
    }

    @Override
    public int getTitleId() {
        return R.string.contact_me;
    }

    @Override
    public int getIconId() {
        return R.drawable.ic_launcher_background;
    }
}
