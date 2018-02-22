package com.erikzuo.portfolioandroidapp.ui.setting

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.MenuItem
import com.erikzuo.portfolioandroidapp.BR

import com.erikzuo.portfolioandroidapp.R
import com.erikzuo.portfolioandroidapp.databinding.ActivitySettingsBinding
import com.erikzuo.portfolioandroidapp.ui.base.BaseActivity
import com.erikzuo.portfolioandroidapp.ui.main.MainViewModel
import com.erikzuo.portfolioandroidapp.viewmodel.ViewModelProviderFactory
import javax.inject.Inject

/**
 * Created by Soprano on 20/02/2018.
 */

class SettingsActivity : BaseActivity<ActivitySettingsBinding, SettingsViewModel>(), SettingsNavigator {

    @Inject
    internal lateinit var mFactory: ViewModelProviderFactory

    private lateinit var mViewModel: SettingsViewModel

    override val viewModel: SettingsViewModel
        get() {
            mViewModel = ViewModelProviders.of(this, mFactory).get(SettingsViewModel::class.java)
            return mViewModel
        }

    override val layoutId: Int
        get() = R.layout.activity_settings

    override val bindingVariable: Int
        get() = BR.viewModel

    override fun initViews() {
        mViewModel.navigator = this

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)


    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId){
            android.R.id.home -> onBackPressed()
        }

        return super.onOptionsItemSelected(item)
    }
}
