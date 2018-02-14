package com.erikzuo.portfolioandroidapp.data

import com.erikzuo.portfolioandroidapp.data.model.Education
import com.erikzuo.portfolioandroidapp.data.model.MyInfo
import com.erikzuo.portfolioandroidapp.data.model.Repo
import com.erikzuo.portfolioandroidapp.data.model.Work

import io.reactivex.Observable

/**
 * Created by YifanZuo on 3/2/18.
 */

interface DataManager {

    val myInfo: Observable<MyInfo>

    val repoListApiCall: Observable<List<Repo>>

    val educationList: Observable<List<Education>>

//    val workList: Observable<List<Work>>
}
