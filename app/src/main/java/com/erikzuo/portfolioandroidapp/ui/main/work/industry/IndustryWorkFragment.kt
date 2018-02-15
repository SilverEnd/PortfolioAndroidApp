package com.erikzuo.portfolioandroidapp.ui.main.work.industry

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle

import com.erikzuo.portfolioandroidapp.BR
import com.erikzuo.portfolioandroidapp.R
import com.erikzuo.portfolioandroidapp.databinding.FragmentIndustryWorkBinding
import com.erikzuo.portfolioandroidapp.ui.base.BaseFragment
import com.erikzuo.portfolioandroidapp.ui.main.work.WorkViewModel
import com.erikzuo.portfolioandroidapp.viewmodel.ViewModelProviderFactory

import javax.inject.Inject

/**
 * Created by YifanZuo on 7/02/2018.
 */

class IndustryWorkFragment : BaseFragment<FragmentIndustryWorkBinding, WorkViewModel>() {

    @Inject
    internal lateinit var mFactory: ViewModelProviderFactory

    private lateinit var mViewModel: WorkViewModel

    override val layoutId: Int
        get() = R.layout.fragment_industry_work

    override val viewModel: WorkViewModel
        get() {
            mViewModel = ViewModelProviders.of(this, mFactory).get(WorkViewModel::class.java)
            return mViewModel
        }

    override val bindingVariable: Int
        get() = BR.viewModel

    override fun initViews() {

    }

    companion object {


        fun newInstance(): IndustryWorkFragment {
            val args = Bundle()
            val fragment = IndustryWorkFragment()
            fragment.arguments = args
            return fragment
        }
    }
}
