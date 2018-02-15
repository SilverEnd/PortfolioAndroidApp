package com.erikzuo.portfolioandroidapp.ui.main.education

import android.support.v7.widget.LinearLayoutManager
import com.erikzuo.portfolioandroidapp.data.model.Education

import java.util.ArrayList

import dagger.Module
import dagger.Provides

/**
 * Created by YifanZuo on 9/02/2018.
 */

@Module
class EducationFragmentModule {

    @Provides
    internal fun provideEducationAdapter(): EducationAdapter {
        return EducationAdapter(ArrayList<Education>())
    }

    @Provides
    internal fun provideLinearLayoutManager(fragment: EducationFragment): LinearLayoutManager {
        return LinearLayoutManager(fragment.activity)
    }
}
