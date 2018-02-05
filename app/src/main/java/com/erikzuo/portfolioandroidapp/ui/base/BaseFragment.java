package com.erikzuo.portfolioandroidapp.ui.base;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import dagger.android.support.AndroidSupportInjection;

/**
 * Created by amitshekhar on 09/07/17.
 */

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.StringRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.erikzuo.portfolioandroidapp.ui.base.BaseActivity;
import com.erikzuo.portfolioandroidapp.ui.base.BaseViewModel;

import dagger.android.support.AndroidSupportInjection;

/**
 * Created by YifanZuo on 3/2/18.
 */

public abstract class BaseFragment<T extends ViewDataBinding, V extends BaseViewModel> extends Fragment {

    private BaseActivity mActivity;
    private T mViewDataBinding;
    private V mViewModel;
    private View mRootView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        performDependencyInjection();
        super.onCreate(savedInstanceState);
        mViewModel = getViewModel();
        setHasOptionsMenu(false);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mViewDataBinding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false);
        mRootView = mViewDataBinding.getRoot();
        return mRootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewDataBinding.setVariable(getBindingVariable(), mViewModel);
        mViewDataBinding.executePendingBindings();
        initViews();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof BaseActivity) {
            BaseActivity activity = (BaseActivity) context;
            this.mActivity = activity;
            activity.onFragmentAttached();
        }
    }

    @Override
    public void onDetach() {
        mActivity = null;
        super.onDetach();
    }

    public BaseActivity getBaseActivity() {
        return mActivity;
    }

    public T getViewDataBinding() {
        return mViewDataBinding;
    }


    public void hideKeyboard() {
        if (mActivity != null) {
            mActivity.hideKeyboard();
        }
    }


    private void performDependencyInjection() {
        AndroidSupportInjection.inject(this);
    }

    public interface Callback {

        void onFragmentAttached();

        void onFragmentDetached(String tag);
    }


    public abstract V getViewModel();

    public abstract int getBindingVariable();

    @LayoutRes
    public abstract int getLayoutId();

    @StringRes
    public abstract int getTitleId();

    @DrawableRes
    public abstract int getIconId();


    public void initViews() {

    }


}
