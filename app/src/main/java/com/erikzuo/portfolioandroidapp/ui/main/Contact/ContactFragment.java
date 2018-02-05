package com.erikzuo.portfolioandroidapp.ui.main.Contact;

import android.os.Bundle;

import com.erikzuo.portfolioandroidapp.BR;
import com.erikzuo.portfolioandroidapp.R;
import com.erikzuo.portfolioandroidapp.databinding.FragmentContactBinding;
import com.erikzuo.portfolioandroidapp.ui.base.BaseFragment;

import javax.inject.Inject;

/**
 * Created by YifanZuo on 4/2/18.
 */

public class ContactFragment extends BaseFragment<FragmentContactBinding, ContactViewModel> implements ContactNavigator {

    @Inject
    ContactViewModel mViewModel;

    public static ContactFragment newInstance(){
        Bundle args = new Bundle();
        ContactFragment fragment = new ContactFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public ContactViewModel getViewModel() {
        return mViewModel;
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
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
