package com.erikzuo.portfolioandroidapp.data

import com.erikzuo.portfolioandroidapp.data.model.*

import io.reactivex.Observable

/**
 * Created by YifanZuo on 3/2/18.
 */

interface DataManager {

    fun getMyInfo(): Observable<MyInfo>

    fun getRepoListApiCall(): Observable<List<Repo>>

    fun getEducationList(): Observable<List<Education>>

    fun getSkillList(): Observable<List<Skill>>
}
