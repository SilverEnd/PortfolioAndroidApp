package com.erikzuo.portfolioandroidapp.ui.main

import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.databinding.DataBindingUtil
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.view.View

import com.erikzuo.portfolioandroidapp.BR
import com.erikzuo.portfolioandroidapp.R
import com.erikzuo.portfolioandroidapp.databinding.ActivityMainBinding
import com.erikzuo.portfolioandroidapp.databinding.NavHeaderMainBinding
import com.erikzuo.portfolioandroidapp.ui.base.BaseActivity
import com.erikzuo.portfolioandroidapp.ui.main.education.EducationFragment
import com.erikzuo.portfolioandroidapp.ui.main.home.HomeFragment
import com.erikzuo.portfolioandroidapp.ui.main.work.WorkFragment
import com.erikzuo.portfolioandroidapp.ui.setting.SettingsActivity
import com.erikzuo.portfolioandroidapp.viewmodel.ViewModelProviderFactory

import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

/**
 * Created by YifanZuo on 3/2/18.
 */

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(), MainNavigator, HasSupportFragmentInjector {


    @Inject
    internal lateinit var mFactory: ViewModelProviderFactory

    @Inject
    internal lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    private lateinit var mViewModel: MainViewModel

    // Fragments
    private val mHomeFragment: HomeFragment = HomeFragment.newInstance()
    private val mWorkFragment: WorkFragment = WorkFragment.newInstance()
    private val mEducationFragment: EducationFragment = EducationFragment.newInstance()


    override val bindingVariable: Int
        get() = BR.viewModel

    override val layoutId: Int
        get() = R.layout.activity_main

    override val viewModel: MainViewModel
        get() {
            mViewModel = ViewModelProviders.of(this, mFactory).get(MainViewModel::class.java)
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
                mHomeFragment,
                getString(R.string.home))
    }

    private fun setupNavDrawer() {
        val drawerToggle = object : ActionBarDrawerToggle(
                this,
                binding.drawerView,
                binding.toolbar,
                R.string.open_drawer,
                R.string.close_drawer) {
            override fun onDrawerOpened(drawerView: View) {
                super.onDrawerOpened(drawerView)
                hideKeyboard()
            }
        }

        binding.drawerView.addDrawerListener(drawerToggle)
        drawerToggle.syncState()
    }

    private fun setupNavMenu() {
        val navHeaderMainBinding = DataBindingUtil.inflate<NavHeaderMainBinding>(
                layoutInflater,
                R.layout.nav_header_main,
                binding.navigationView,
                false)

        binding.navigationView.addHeaderView(navHeaderMainBinding.root)
        navHeaderMainBinding.viewModel = this.viewModel

        binding.navigationView.setNavigationItemSelectedListener { item ->
            binding.drawerView.closeDrawer(GravityCompat.START)

            this.viewModel.setIsLoading(false)
            when (item.itemId) {
                R.id.navItemHome -> {
                    showFragment(
                            mHomeFragment,
                            getString(R.string.home))

                    true
                }
                R.id.navItemWork -> {
                    showFragment(
                            mWorkFragment,
                            getString(R.string.work))

                    true
                }
                R.id.navItemEducation -> {
                    showFragment(
                            mEducationFragment,
                            getString(R.string.education))

                    true
                }
                R.id.navItemSetting -> {
                    goToSettings()

                    true
                }
                else -> false
            }
        }
    }

    private fun showFragment(fragment: Fragment, title: String) {
        val fragmentTransaction: FragmentTransaction = supportFragmentManager.beginTransaction()

        if (supportFragmentManager.findFragmentByTag(fragment.javaClass.name) == null) {
            fragmentTransaction
                    .addToBackStack( fragment.javaClass.name)
                    .add(R.id.clRootView, fragment, fragment.javaClass.name)
        }

        fragmentTransaction
                .hide(mHomeFragment)
                .hide(mWorkFragment)
                .hide(mEducationFragment)
                .show(fragment)
                .commit()

        this.viewModel.setPageTitle(title)
    }

    private fun goToSettings() {
        startActivity(Intent(this, SettingsActivity::class.java))
    }
}
