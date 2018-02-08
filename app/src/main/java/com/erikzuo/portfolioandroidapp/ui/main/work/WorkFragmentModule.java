package com.erikzuo.portfolioandroidapp.ui.main.work;

import android.support.v7.widget.LinearLayoutManager;

import com.erikzuo.portfolioandroidapp.data.model.Repo;
import com.erikzuo.portfolioandroidapp.ui.base.BaseFragment;
import com.erikzuo.portfolioandroidapp.ui.main.work.personal.RepoAdapter;

import java.util.ArrayList;

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
