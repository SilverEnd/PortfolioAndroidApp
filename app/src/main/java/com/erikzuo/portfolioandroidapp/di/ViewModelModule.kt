package com.erikzuo.portfolioandroidapp.di

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider

import com.erikzuo.portfolioandroidapp.ui.contact.ContactViewModel
import com.erikzuo.portfolioandroidapp.ui.main.MainViewModel
import com.erikzuo.portfolioandroidapp.ui.main.education.EducationViewModel
import com.erikzuo.portfolioandroidapp.ui.main.home.HomeViewModel
import com.erikzuo.portfolioandroidapp.ui.main.work.WorkViewModel
import com.erikzuo.portfolioandroidapp.viewmodel.ViewModelProviderFactory

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(viewModel: MainViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindHomeViewModel(viewModel: HomeViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(WorkViewModel::class)
    abstract fun bindWorkViewModel(viewModel: WorkViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(EducationViewModel::class)
    abstract fun bindEducationViewModel(viewModel: EducationViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ContactViewModel::class)
    abstract fun bindContactViewModel(viewModel: ContactViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelProviderFactory): ViewModelProvider.Factory

}
