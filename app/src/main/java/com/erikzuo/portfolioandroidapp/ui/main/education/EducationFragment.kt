package com.erikzuo.portfolioandroidapp.ui.main.education

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager

import com.erikzuo.portfolioandroidapp.BR
import com.erikzuo.portfolioandroidapp.R
import com.erikzuo.portfolioandroidapp.databinding.FragmentEducationBinding
import com.erikzuo.portfolioandroidapp.ui.base.BaseFragment
import com.erikzuo.portfolioandroidapp.viewmodel.ViewModelProviderFactory

import javax.inject.Inject

/**
 * Created by Soprano on 9/02/2018.
 */

class EducationFragment : BaseFragment<FragmentEducationBinding, EducationViewModel>() {

    @Inject
    internal lateinit var mFactory: ViewModelProviderFactory

    @Inject
    internal lateinit var mAdapter: EducationAdapter

    @Inject
    internal lateinit var mLayoutManager: LinearLayoutManager


    private lateinit var mViewModel: EducationViewModel


    override val layoutId: Int
        get() = R.layout.fragment_education

    override val viewModel: EducationViewModel
        get() {
            mViewModel = ViewModelProviders.of(this, mFactory).get(EducationViewModel::class.java)

            return mViewModel
        }

    override val bindingVariable: Int
        get() = BR.viewModel

    override fun initViews() {
        mLayoutManager!!.orientation = LinearLayoutManager.VERTICAL
        viewDataBinding!!.list.layoutManager = mLayoutManager
        viewDataBinding!!.list.itemAnimator = DefaultItemAnimator()
        viewDataBinding!!.list.adapter = mAdapter
    }

    companion object {


        fun newInstance(): EducationFragment {
            val args = Bundle()
            val fragment = EducationFragment()
            fragment.arguments = args
            return fragment
        }
    }
}
