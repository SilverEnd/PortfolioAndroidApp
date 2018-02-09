package com.erikzuo.portfolioandroidapp.ui.main.education;

import android.databinding.ObservableField;

import com.erikzuo.portfolioandroidapp.data.model.Education;

/**
 * Created by Soprano on 9/02/2018.
 */

public class EducationItemViewModel {
    private Education mEducation;

    public ObservableField<String> name;
    public ObservableField<String> degree;

    public EducationItemViewModel(Education education) {
        this.mEducation = education;

        name = new ObservableField<>(mEducation.getName());
        degree = new ObservableField<>(mEducation.getDegree());
    }


}
