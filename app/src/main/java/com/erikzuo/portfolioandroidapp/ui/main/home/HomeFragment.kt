package com.erikzuo.portfolioandroidapp.ui.main.home

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle

import com.erikzuo.portfolioandroidapp.BR
import com.erikzuo.portfolioandroidapp.R
import com.erikzuo.portfolioandroidapp.databinding.FragmenHomeBinding
import com.erikzuo.portfolioandroidapp.ui.base.BaseFragment
import com.erikzuo.portfolioandroidapp.viewmodel.ViewModelProviderFactory

import javax.inject.Inject

/**
 * Created by YifanZuo on 5/2/18.
 */

class HomeFragment : BaseFragment<FragmenHomeBinding, HomeViewModel>(), HomeNavigator {

    @Inject
    internal lateinit var mFactory: ViewModelProviderFactory

    private lateinit var mViewModel: HomeViewModel


    override val viewModel: HomeViewModel
        get() {
            mViewModel = ViewModelProviders.of(this, mFactory).get(HomeViewModel::class.java)

            return mViewModel
        }

    override val bindingVariable: Int
        get() = BR.viewModel

    override val layoutId: Int
        get() = R.layout.fragmen_home

    override fun initViews() {

    }

    companion object {
        val TAG = "HomeFragment"

        fun newInstance(): HomeFragment {
            val args = Bundle()
            val fragment = HomeFragment()
            fragment.arguments = args
            return fragment
        }
    }

}
