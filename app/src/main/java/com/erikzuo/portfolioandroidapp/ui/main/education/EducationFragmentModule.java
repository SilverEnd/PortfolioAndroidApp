package com.erikzuo.portfolioandroidapp.ui.main.education;

import android.support.v7.widget.LinearLayoutManager;

import com.erikzuo.portfolioandroidapp.data.model.Education;
import com.erikzuo.portfolioandroidapp.data.model.Repo;
import com.erikzuo.portfolioandroidapp.ui.main.work.personal.PersonalWorkFragment;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Soprano on 9/02/2018.
 */

@Module
public class EducationFragmentModule {

    @Provides
    EducationAdapter provideEducationAdapter() {
        return new EducationAdapter(new ArrayList<>());
    }

    @Provides
    LinearLayoutManager provideLinearLayoutManager(EducationFragment fragment) {
        return new LinearLayoutManager(fragment.getActivity());
    }
}
