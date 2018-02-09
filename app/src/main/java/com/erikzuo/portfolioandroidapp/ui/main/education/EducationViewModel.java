package com.erikzuo.portfolioandroidapp.ui.main.education;

import android.databinding.ObservableArrayList;
import android.util.Log;

import com.erikzuo.portfolioandroidapp.data.DataManager;
import com.erikzuo.portfolioandroidapp.data.model.Education;
import com.erikzuo.portfolioandroidapp.ui.base.BaseViewModel;
import com.erikzuo.portfolioandroidapp.utils.rx.SchedulerProvider;

import javax.inject.Inject;

/**
 * Created by Soprano on 9/02/2018.
 */

public class EducationViewModel extends BaseViewModel {

    private final ObservableArrayList<Education> mEducationList = new ObservableArrayList<>();

    @Inject
    public EducationViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);

        loadEducation();
    }

    private void loadEducation() {
        setIsLoading(true);
        getCompositeDisposable().add(getDataManager()
                .getEducationList()
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(
                        educations -> {
                            mEducationList.addAll(educations);
                            setIsLoading(false);
                            Log.d("education", mEducationList.get(0).getDegree() + "");
                        }));
    }

    public ObservableArrayList<Education> getEducationList() {
        return mEducationList;
    }
}
