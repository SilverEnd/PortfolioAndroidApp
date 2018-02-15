package com.erikzuo.portfolioandroidapp.ui.main.work

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment

import com.erikzuo.portfolioandroidapp.BR
import com.erikzuo.portfolioandroidapp.R
import com.erikzuo.portfolioandroidapp.databinding.FragmentWorkBinding
import com.erikzuo.portfolioandroidapp.ui.base.BaseFragment
import com.erikzuo.portfolioandroidapp.viewmodel.ViewModelProviderFactory

import javax.inject.Inject

import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector

/**
 * Created by YifanZuo on 7/02/2018.
 */

class WorkFragment : BaseFragment<FragmentWorkBinding, WorkViewModel>(), WorkNavigator, HasSupportFragmentInjector {

    @Inject
    internal lateinit var mFactory: ViewModelProviderFactory

    @Inject
    internal lateinit var mPageAdapter: WorkPagerAdapter

    @Inject
    internal lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>


    private lateinit var mViewModel: WorkViewModel

    override val layoutId: Int
        get() = R.layout.fragment_work

    override val viewModel: WorkViewModel
        get() {
            mViewModel = ViewModelProviders.of(this, mFactory).get(WorkViewModel::class.java)

            return mViewModel
        }

    override val bindingVariable: Int
        get() = BR.viewModel

    override fun initViews() {
        viewDataBinding.tabLayout.addTab(viewDataBinding.tabLayout.newTab().setText(R.string.industry_work).setIcon(R.drawable.ic_work))
        viewDataBinding.tabLayout.addTab(viewDataBinding.tabLayout.newTab().setText(R.string.personal_work).setIcon(R.drawable.ic_github))
        viewDataBinding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewDataBinding!!.pager.currentItem = tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {

            }

            override fun onTabReselected(tab: TabLayout.Tab) {

            }
        })

        viewDataBinding.pager.adapter = mPageAdapter
        viewDataBinding.pager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(viewDataBinding!!.tabLayout))

    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment>? {
        return fragmentDispatchingAndroidInjector
    }

    companion object {

        fun newInstance(): WorkFragment {
            val args = Bundle()
            val fragment = WorkFragment()
            fragment.arguments = args
            return fragment
        }
    }
}
