package com.erikzuo.portfolioandroidapp.ui.main.home


import android.databinding.ObservableArrayList
import android.util.Log
import com.erikzuo.portfolioandroidapp.data.DataManager
import com.erikzuo.portfolioandroidapp.data.model.Skill
import com.erikzuo.portfolioandroidapp.ui.base.BaseViewModel
import com.erikzuo.portfolioandroidapp.utils.rx.SchedulerProvider
import java.util.logging.Logger

import javax.inject.Inject

/**
 * Created by YifanZuo on 5/2/18.
 */

class HomeViewModel
@Inject
constructor(dataManager: DataManager, schedulerProvider: SchedulerProvider) : BaseViewModel<HomeNavigator>(dataManager, schedulerProvider) {

    val skillList = ObservableArrayList<Skill>()

    init {
        loadMyInfo()
        loadSkills()
    }

    private fun loadSkills() {
        compositeDisposable.add(dataManager.getSkillList()
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
                .subscribe(
                        { skills ->
                            skillList.addAll(skills)
                        }
                ) { throwable ->

                }
        )
    }
}
