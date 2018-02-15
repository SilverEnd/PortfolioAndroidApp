package com.erikzuo.portfolioandroidapp.ui.base

import android.annotation.TargetApi
import android.content.Context
import android.content.pm.PackageManager
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Build
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity
import android.view.inputmethod.InputMethodManager

import dagger.android.AndroidInjection

/**
 * Created by YifanZuo on 3/2/18.
 */

abstract class BaseActivity<T : ViewDataBinding, out V : BaseViewModel<*>> : AppCompatActivity(), BaseFragment.Callback {

    internal lateinit var viewDatabinding: T

    abstract val viewModel: V

    @get:LayoutRes
    abstract val layoutId: Int

    abstract val bindingVariable: Int


    override fun onCreate(savedInstanceState: Bundle?) {
        performDependencyInjection()
        super.onCreate(savedInstanceState)
        performDataBinding()
        initViews()
    }

    private fun performDataBinding() {
        viewDatabinding = DataBindingUtil.setContentView(this, layoutId)
        viewDatabinding.setVariable(bindingVariable, viewModel)
        viewDatabinding.executePendingBindings()
    }

    @TargetApi(Build.VERSION_CODES.M)
    fun requestPermissionsSafely(permissions: Array<String>, requestCode: Int) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(permissions, requestCode)
        }
    }

    @TargetApi(Build.VERSION_CODES.M)
    fun hasPermission(permission: String): Boolean {
        return Build.VERSION.SDK_INT < Build.VERSION_CODES.M || checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED
    }

    override fun onFragmentAttached() {

    }

    override fun onFragmentDetached(tag: String) {

    }

    fun hideKeyboard() {
        if (this.currentFocus != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(this.currentFocus.windowToken, 0)
        }
    }

    private fun performDependencyInjection() {
        AndroidInjection.inject(this)
    }

    abstract fun initViews()
}

