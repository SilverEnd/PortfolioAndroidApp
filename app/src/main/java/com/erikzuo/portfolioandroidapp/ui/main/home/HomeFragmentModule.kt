package com.erikzuo.portfolioandroidapp.ui.main.home

import android.support.v7.widget.LinearLayoutManager

import java.util.ArrayList

import dagger.Module
import dagger.Provides

/**
 * Created by YifanZuo on 8/2/18.
 */

@Module
class HomeFragmentModule {

    @Provides
    internal fun provideLinearLayoutManager(fragment: HomeFragment): LinearLayoutManager {
        return LinearLayoutManager(fragment.activity)
    }


    @Provides
    internal fun provideRepoAdapter(): SkillAdapter {
        return SkillAdapter(ArrayList())
    }
}
