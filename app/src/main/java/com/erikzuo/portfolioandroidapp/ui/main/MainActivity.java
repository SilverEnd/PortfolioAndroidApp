package com.erikzuo.portfolioandroidapp.ui.main;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.view.View;

import com.erikzuo.portfolioandroidapp.BR;
import com.erikzuo.portfolioandroidapp.R;
import com.erikzuo.portfolioandroidapp.databinding.ActivityMainBinding;
import com.erikzuo.portfolioandroidapp.databinding.NavHeaderMainBinding;
import com.erikzuo.portfolioandroidapp.ui.base.BaseActivity;
import com.erikzuo.portfolioandroidapp.ui.main.contact.ContactFragment;
import com.erikzuo.portfolioandroidapp.ui.main.home.HomeFragment;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

/**
 * Created by YifanZuo on 3/2/18.
 */

public class MainActivity extends BaseActivity<ActivityMainBinding, MainViewModel> implements MainNavigator, HasSupportFragmentInjector {

    @Inject
    ViewModelProvider.Factory mViewModelFactory;

    @Inject
    DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector;

    private MainViewModel mViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public MainViewModel getViewModel() {
        mViewModel = ViewModelProviders.of(this, mViewModelFactory).get(MainViewModel.class);

        return mViewModel;
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return fragmentDispatchingAndroidInjector;
    }

    @Override
    public void initViews() {
        setupNavDrawer();
        setupNavMenu();

        // When we first opened this activity, display Home fragment
        showFragment(
                HomeFragment.newInstance(),
                getString(R.string.home));
    }

    private void setupNavDrawer() {
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(
                this,
                getViewDataBinding().drawerView,
                getViewDataBinding().toolbar,
                R.string.open_drawer,
                R.string.close_drawer) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                hideKeyboard();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };

        getViewDataBinding().drawerView.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
    }

    private void setupNavMenu() {
        NavHeaderMainBinding navHeaderMainBinding = DataBindingUtil.inflate(getLayoutInflater(),
                R.layout.nav_header_main, getViewDataBinding().navigationView, false);
        getViewDataBinding().navigationView.addHeaderView(navHeaderMainBinding.getRoot());
        navHeaderMainBinding.setViewModel(mViewModel);

        getViewDataBinding().navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        getViewDataBinding().drawerView.closeDrawer(GravityCompat.START);

                        mViewModel.setIsLoading(false);
                        switch (item.getItemId()) {
                            case R.id.navItemHome:
                                showFragment(
                                        HomeFragment.newInstance(),
                                        getString(R.string.home));

                                return true;
                            case R.id.navItemContact:
                                showFragment(
                                        ContactFragment.newInstance(),
                                        getString(R.string.contact));

                                return true;
                            default:
                                return false;
                        }
                    }
                });
    }

    private void showFragment(Fragment fragment, String title) {
        getSupportFragmentManager()
                .beginTransaction()
                .disallowAddToBackStack()
                .replace(R.id.clRootView, fragment)
                .commit();

        mViewModel.setPageTitle(title);
    }
}
