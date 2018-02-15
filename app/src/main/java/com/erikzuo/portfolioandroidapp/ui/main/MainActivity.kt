package com.erikzuo.portfolioandroidapp.ui.main

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.databinding.DataBindingUtil
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.view.View

import com.erikzuo.portfolioandroidapp.BR
import com.erikzuo.portfolioandroidapp.R
import com.erikzuo.portfolioandroidapp.databinding.ActivityMainBinding
import com.erikzuo.portfolioandroidapp.databinding.NavHeaderMainBinding
import com.erikzuo.portfolioandroidapp.ui.base.BaseActivity
import com.erikzuo.portfolioandroidapp.ui.contact.ContactActivity
import com.erikzuo.portfolioandroidapp.ui.main.education.EducationFragment
import com.erikzuo.portfolioandroidapp.ui.main.home.HomeFragment
import com.erikzuo.portfolioandroidapp.ui.main.work.WorkFragment

import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

/**
 * Created by YifanZuo on 3/2/18.
 */

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(), MainNavigator, HasSupportFragmentInjector {


    @Inject
    internal lateinit var mViewModelFactory: ViewModelProvider.Factory

    @Inject
    internal lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    private lateinit var mViewModel: MainViewModel


    override val bindingVariable: Int
        get() = BR.viewModel

    override val layoutId: Int
        get() = R.layout.activity_main

    override val viewModel: MainViewModel
        get() {
            mViewModel = ViewModelProviders.of(this, mViewModelFactory).get(MainViewModel::class.java)
            return mViewModel
        }

    override fun supportFragmentInjector(): AndroidInjector<Fragment>? {
        return fragmentDispatchingAndroidInjector
    }


    override fun initViews() {
        viewModel.navigator = this
        setupNavDrawer()
        setupNavMenu()

        // When we first opened this activity, display Home fragment
        showFragment(
                HomeFragment.newInstance(),
                getString(R.string.home))
    }

    private fun setupNavDrawer() {
        val drawerToggle = object : ActionBarDrawerToggle(
                this,
                viewDatabinding.drawerView,
                viewDatabinding.toolbar,
                R.string.open_drawer,
                R.string.close_drawer) {
            override fun onDrawerOpened(drawerView: View) {
                super.onDrawerOpened(drawerView)
                hideKeyboard()
            }
        }

        viewDatabinding.drawerView.addDrawerListener(drawerToggle)
        drawerToggle.syncState()
    }

    private fun setupNavMenu() {
        val navHeaderMainBinding = DataBindingUtil.inflate<NavHeaderMainBinding>(
                layoutInflater,
                R.layout.nav_header_main,
                viewDatabinding.navigationView,
                false)

        viewDatabinding.navigationView.addHeaderView(navHeaderMainBinding.root)
        navHeaderMainBinding.viewModel = this.viewModel

        viewDatabinding.navigationView.setNavigationItemSelectedListener { item ->
            viewDatabinding.drawerView.closeDrawer(GravityCompat.START)

            this.viewModel.setIsLoading(false)
            when (item.itemId) {
                R.id.navItemHome -> {
                    showFragment(
                            HomeFragment.newInstance(),
                            getString(R.string.home))

                    true
                }
                R.id.navItemWork -> {
                    showFragment(
                            WorkFragment.newInstance(),
                            getString(R.string.work))

                    true
                }
                R.id.navItemEducation -> {
                    showFragment(
                            EducationFragment.newInstance(),
                            getString(R.string.education))

                    true
                }
                R.id.navItemContact -> {
                    goToContact()

                    true
                }
                else -> false
            }
        }
    }

    private fun showFragment(fragment: Fragment, title: String) {
        supportFragmentManager
                .beginTransaction()
                .disallowAddToBackStack()
                .replace(R.id.clRootView, fragment)
                .commit()

        this.viewModel.setPageTitle(title)
    }

    private fun goToContact() {
        startActivity(Intent(this, ContactActivity::class.java))
    }
}
