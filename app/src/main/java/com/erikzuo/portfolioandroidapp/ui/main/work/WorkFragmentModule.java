package com.erikzuo.portfolioandroidapp.ui.main.work;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Soprano on 7/02/2018.
 */

@Module
public class WorkFragmentModule {

    @Provides
    WorkPagerAdapter provideWorkPagerAdapter(WorkFragment fragment) {
        return new WorkPagerAdapter(fragment.getChildFragmentManager());
    }
}
