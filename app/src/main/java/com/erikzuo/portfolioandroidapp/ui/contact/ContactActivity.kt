package com.erikzuo.portfolioandroidapp.ui.contact

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.view.MenuItem
import com.erikzuo.portfolioandroidapp.BR

import com.erikzuo.portfolioandroidapp.R
import com.erikzuo.portfolioandroidapp.databinding.ActivityContactBinding
import com.erikzuo.portfolioandroidapp.ui.base.BaseActivity

import javax.inject.Inject

/**
 * Created by YifanZuo on 12/02/2018.
 */

class ContactActivity : BaseActivity<ActivityContactBinding, ContactViewModel>() {

    @Inject
    internal lateinit var mFactory: ViewModelProvider.Factory

    private lateinit var mViewModel: ContactViewModel

    override val viewModel: ContactViewModel
        get() {
            mViewModel = ViewModelProviders.of(this, mFactory).get(ContactViewModel::class.java)

            return mViewModel
        }

    override val bindingVariable: Int
        get() = BR.viewModel

    override val layoutId: Int
        get() = R.layout.activity_contact

    override fun initViews() {
        setSupportActionBar(viewDatabinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.title = getString(R.string.contact)
    }


    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId){
            android.R.id.home -> onBackPressed()
        }

        return super.onOptionsItemSelected(item)
    }
}
