package com.erikzuo.portfolioandroidapp.ui.main.home

import android.databinding.ObservableInt

import com.erikzuo.portfolioandroidapp.data.DataManager
import com.erikzuo.portfolioandroidapp.ui.base.BaseViewModel
import com.erikzuo.portfolioandroidapp.utils.rx.SchedulerProvider

import javax.inject.Inject

/**
 * Created by YifanZuo on 5/2/18.
 */

class HomeViewModel
//    private final ObservableInt m

@Inject
constructor(dataManager: DataManager, schedulerProvider: SchedulerProvider) : BaseViewModel<HomeNavigator>(dataManager, schedulerProvider) {
    init {
        loadMyInfo()
    }

    private fun loadMyInfo() {
        setIsLoading(true)
        compositeDisposable.add(dataManager.myInfo
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
