package com.erikzuo.portfolioandroidapp.ui.main.work.personal;

import android.support.v7.widget.LinearLayoutManager;

import com.erikzuo.portfolioandroidapp.data.model.Repo;
import com.erikzuo.portfolioandroidapp.ui.base.BaseFragment;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;

/**
 * Created by YifanZuo on 8/2/18.
 */

@Module
public class PersonalWorkFragmentModule {

    @Provides
    LinearLayoutManager provideLinearLayoutManager(PersonalWorkFragment fragment) {
        return new LinearLayoutManager(fragment.getActivity());
    }


    @Provides
    RepoAdapter provideRepoAdapter() {
        return new RepoAdapter(new ArrayList<Repo>());
    }
}
