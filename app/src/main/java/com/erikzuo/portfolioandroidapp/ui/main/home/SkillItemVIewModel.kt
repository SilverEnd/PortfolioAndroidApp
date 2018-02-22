package com.erikzuo.portfolioandroidapp.ui.main.home

import android.databinding.ObservableField
import android.databinding.ObservableFloat
import com.erikzuo.portfolioandroidapp.data.model.Skill

/**
 * Created by Soprano on 22/02/2018.
 */
class SkillItemVIewModel(private val skill : Skill){

    var name : ObservableField<String> = ObservableField(skill.name)
    var description : ObservableField<String> = ObservableField(skill.description)
    var proficiency : ObservableFloat = ObservableFloat(skill.proficiency)

}