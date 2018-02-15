package com.erikzuo.portfolioandroidapp.ui.main.work.personal

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager

import com.erikzuo.portfolioandroidapp.BR
import com.erikzuo.portfolioandroidapp.R
import com.erikzuo.portfolioandroidapp.databinding.FragmentPersonalWorkBinding
import com.erikzuo.portfolioandroidapp.ui.base.BaseFragment
import com.erikzuo.portfolioandroidapp.ui.main.work.WorkViewModel
import com.erikzuo.portfolioandroidapp.viewmodel.ViewModelProviderFactory

import javax.inject.Inject

/**
 * Created by YifanZuo on 7/02/2018.
 */

class PersonalWorkFragment : BaseFragment<FragmentPersonalWorkBinding, WorkViewModel>() {

    @Inject
    internal lateinit var mFactory: ViewModelProviderFactory


    @Inject
    internal lateinit var mAdapter: RepoAdapter

    @Inject
    internal lateinit var mLayoutManager: LinearLayoutManager


    private lateinit var mViewModel: WorkViewModel

    override val layoutId: Int
        get() = R.layout.fragment_personal_work

    override val viewModel: WorkViewModel
        get() {
            mViewModel = ViewModelProviders.of(this, mFactory).get(WorkViewModel::class.java)
            return mViewModel
        }

    override val bindingVariable: Int
        get() = BR.viewModel

    override fun initViews() {
        mLayoutManager.orientation = LinearLayoutManager.VERTICAL
        viewDataBinding.list.layoutManager = mLayoutManager
        viewDataBinding.list.itemAnimator = DefaultItemAnimator()
        viewDataBinding.list.adapter = mAdapter

    }

    companion object {

        fun newInstance(): PersonalWorkFragment {
            val args = Bundle()
            val fragment = PersonalWorkFragment()
            fragment.arguments = args
            return fragment
        }
    }
}
