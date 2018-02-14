package com.erikzuo.portfolioandroidapp.ui.base

import android.content.Context
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.annotation.DrawableRes
import android.support.annotation.LayoutRes
import android.support.annotation.StringRes
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import dagger.android.support.AndroidSupportInjection

import com.erikzuo.portfolioandroidapp.ui.base.BaseActivity
import com.erikzuo.portfolioandroidapp.ui.base.BaseViewModel

/**
 * Created by amitshekhar on 09/07/17.
 */

/**
 * Created by YifanZuo on 3/2/18.
 */

abstract class BaseFragment<T : ViewDataBinding, V : BaseViewModel<*>> : Fragment() {

    var baseActivity: BaseActivity<*, *>? = null
        private set
    internal lateinit var viewDataBinding: T

    private var mViewModel: V? = null
    private var mRootView: View? = null

    @get:LayoutRes
    abstract val layoutId: Int

    abstract val viewModel: V

    abstract val bindingVariable: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        performDependencyInjection()
        super.onCreate(savedInstanceState)
        mViewModel = viewModel
        setHasOptionsMenu(false)
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        viewDataBinding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        mRootView = viewDataBinding!!.root
        return mRootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewDataBinding!!.setVariable(bindingVariable, mViewModel)
        viewDataBinding!!.executePendingBindings()
        initViews()
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is BaseActivity<*, *>) {
            val activity = context as BaseActivity<*, *>?
            this.baseActivity = activity
            activity!!.onFragmentAttached()
        }
    }

    override fun onDetach() {
        baseActivity = null
        super.onDetach()
    }

    abstract fun initViews()


    fun hideKeyboard() {
        if (baseActivity != null) {
            baseActivity!!.hideKeyboard()
        }
    }


    private fun performDependencyInjection() {
        AndroidSupportInjection.inject(this)
    }

    interface Callback {

        fun onFragmentAttached()

        fun onFragmentDetached(tag: String)
    }


}
