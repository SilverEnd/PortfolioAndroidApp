package com.erikzuo.portfolioandroidapp.ui.main.education

import android.databinding.ObservableField

import com.erikzuo.portfolioandroidapp.data.model.Education

/**
 * Created by Soprano on 9/02/2018.
 */

class EducationItemViewModel(private val mEducation: Education) {

    var name: ObservableField<String?> = ObservableField(mEducation.name)
    var degree: ObservableField<String?> = ObservableField(mEducation.degree)


}
