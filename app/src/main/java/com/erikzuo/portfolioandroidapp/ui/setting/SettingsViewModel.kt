package com.erikzuo.portfolioandroidapp.ui.setting

import com.erikzuo.portfolioandroidapp.data.DataManager
import com.erikzuo.portfolioandroidapp.ui.base.BaseViewModel
import com.erikzuo.portfolioandroidapp.utils.rx.SchedulerProvider
import javax.inject.Inject

/**
 * Created by Soprano on 21/02/2018.
 */

class SettingsViewModel  @Inject
constructor(dataManager: DataManager, schedulerProvider: SchedulerProvider) : BaseViewModel<SettingsNavigator>(dataManager, schedulerProvider)
