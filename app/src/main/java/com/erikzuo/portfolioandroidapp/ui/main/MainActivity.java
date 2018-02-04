package com.erikzuo.portfolioandroidapp.ui.main;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.view.MenuItem;

import com.erikzuo.portfolioandroidapp.BR;
import com.erikzuo.portfolioandroidapp.R;
import com.erikzuo.portfolioandroidapp.databinding.ActivityMainBinding;
import com.erikzuo.portfolioandroidapp.ui.base.BaseActivity;

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
    public void initViews() {
        super.initViews();

        getViewDataBinding().navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                getViewDataBinding().drawerView.closeDrawer(GravityCompat.START);
                return onNavItemSelected(item.getItemId());
            }
        });
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


    private boolean onNavItemSelected(int id) {
        switch (id) {
//            case R.id.navItemMarket:
//                showMarketFragment();
//                return true;
            default:
                return false;
        }
    }

    private void showMarketFragment() {
//        getSupportFragmentManager()
//                .beginTransaction()
//                .disallowAddToBackStack()
////                .setCustomAnimations(R.anim.slide_left, R.anim.slide_right)
//                .add(R.id.clRootView, ContactFragment.newInstance(), MarketFragment.TAG)
//                .commit();
    }
}
