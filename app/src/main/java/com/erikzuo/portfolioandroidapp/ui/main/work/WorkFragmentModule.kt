package com.erikzuo.portfolioandroidapp.ui.main.work

import dagger.Module
import dagger.Provides

/**
 * Created by Soprano on 7/02/2018.
 */

@Module
class WorkFragmentModule {

    @Provides
    internal fun provideWorkPagerAdapter(fragment: WorkFragment): WorkPagerAdapter {
        return WorkPagerAdapter(fragment.childFragmentManager)
    }


}
