package com.erikzuo.portfolioandroidapp.ui.main.education

import android.databinding.ObservableArrayList
import android.util.Log

import com.erikzuo.portfolioandroidapp.data.DataManager
import com.erikzuo.portfolioandroidapp.data.model.Education
import com.erikzuo.portfolioandroidapp.ui.base.BaseViewModel
import com.erikzuo.portfolioandroidapp.utils.rx.SchedulerProvider

import javax.inject.Inject

/**
 * Created by YifanZuo on 9/02/2018.
 */

class EducationViewModel @Inject
constructor(dataManager: DataManager, schedulerProvider: SchedulerProvider) : BaseViewModel<EducationNavigator>(dataManager, schedulerProvider) {

    val educationList = ObservableArrayList<Education>()

    init {
        loadEducation()
    }

    private fun loadEducation() {
        setIsLoading(true)
        compositeDisposable.add(dataManager
                .getEducationList()
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
                .subscribe { educations ->
                    educationList.addAll(educations)
                    setIsLoading(false)
                    Log.d("education", educationList[0].degree!! + "")
                })
    }
}
