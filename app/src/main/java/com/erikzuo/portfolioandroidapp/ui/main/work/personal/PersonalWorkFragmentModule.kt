package com.erikzuo.portfolioandroidapp.ui.main.work.personal

import android.support.v7.widget.LinearLayoutManager

import com.erikzuo.portfolioandroidapp.data.model.Repo
import com.erikzuo.portfolioandroidapp.ui.base.BaseFragment

import java.util.ArrayList

import dagger.Module
import dagger.Provides

/**
 * Created by YifanZuo on 8/2/18.
 */

@Module
class PersonalWorkFragmentModule {

    @Provides
    internal fun provideLinearLayoutManager(fragment: PersonalWorkFragment): LinearLayoutManager {
        return LinearLayoutManager(fragment.activity)
    }


    @Provides
    internal fun provideRepoAdapter(): RepoAdapter {
        return RepoAdapter(ArrayList())
    }
}
