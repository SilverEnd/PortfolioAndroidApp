package com.erikzuo.portfolioandroidapp.ui.contact

import com.erikzuo.portfolioandroidapp.data.DataManager
import com.erikzuo.portfolioandroidapp.ui.base.BaseViewModel
import com.erikzuo.portfolioandroidapp.utils.rx.SchedulerProvider

import javax.inject.Inject

/**
 * Created by Soprano on 12/02/2018.
 */

class ContactViewModel @Inject
constructor(dataManager: DataManager, schedulerProvider: SchedulerProvider) : BaseViewModel<ContactNavigator>(dataManager, schedulerProvider)
