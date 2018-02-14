package com.erikzuo.portfolioandroidapp.ui.main


import com.erikzuo.portfolioandroidapp.data.DataManager
import com.erikzuo.portfolioandroidapp.ui.base.BaseViewModel
import com.erikzuo.portfolioandroidapp.utils.rx.SchedulerProvider

import javax.inject.Inject

/**
 * Created by YifanZuo on 4/2/18.
 */

class MainViewModel @Inject
constructor(dataManager: DataManager, schedulerProvider: SchedulerProvider) : BaseViewModel<MainNavigator>(dataManager, schedulerProvider) {

    init {
        loadMyInfo()
    }


    private fun loadMyInfo() {
        compositeDisposable.add(dataManager.myInfo
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
                .subscribe(
                        { myInfo -> setMyInfo(myInfo) }
                ) { throwable ->

                }
        )
    }

}
