package com.erikzuo.portfolioandroidapp.ui.main.work

import android.databinding.ObservableArrayList

import com.erikzuo.portfolioandroidapp.data.DataManager
import com.erikzuo.portfolioandroidapp.data.model.Repo
import com.erikzuo.portfolioandroidapp.ui.base.BaseViewModel
import com.erikzuo.portfolioandroidapp.utils.rx.SchedulerProvider

import javax.inject.Inject

/**
 * Created by YifanZuo on 7/02/2018.
 */

class WorkViewModel @Inject
constructor(dataManager: DataManager, schedulerProvider: SchedulerProvider) : BaseViewModel<WorkNavigator>(dataManager, schedulerProvider) {

    val repoList = ObservableArrayList<Repo>()

    init {

        loadRepos()
    }

    private fun loadRepos() {
        setIsLoading(true)
        compositeDisposable.add(dataManager
                .getRepoListApiCall()
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
                .subscribe { repos ->
                    repoList.addAll(repos)
                    setIsLoading(false)
                }
        )
    }

}
