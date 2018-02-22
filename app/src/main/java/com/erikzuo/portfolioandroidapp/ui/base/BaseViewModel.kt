package com.erikzuo.portfolioandroidapp.ui.base

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableBoolean
import android.databinding.ObservableField
import android.util.Log


import com.erikzuo.portfolioandroidapp.data.DataManager
import com.erikzuo.portfolioandroidapp.data.model.MyInfo
import com.erikzuo.portfolioandroidapp.utils.rx.SchedulerProvider

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Consumer

/**
 * Created by YifanZuo on 3/2/18.
 */

abstract class BaseViewModel<N>(val dataManager: DataManager, val schedulerProvider: SchedulerProvider) : ViewModel() {

    val pageTitle = ObservableField<String>()
    val isLoading = ObservableBoolean(false)
    val myInfo = ObservableField<MyInfo>()
    var navigator: N? = null

    val compositeDisposable: CompositeDisposable = CompositeDisposable()


    fun setIsLoading(isLoading: Boolean) {
        this.isLoading.set(isLoading)
    }

    fun setPageTitle(title: String) {
        pageTitle.set(title)
    }

    fun setMyInfo(myInfo: MyInfo) {
        this.myInfo.set(myInfo)
    }

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }

    fun loadMyInfo() {
        setIsLoading(true)
        compositeDisposable.add(dataManager.getMyInfo()
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
                .subscribe(
                        { myInfo ->
                            setMyInfo(myInfo)
                            setIsLoading(false)
                        }
                ) { throwable ->

                }
        )
    }
}
