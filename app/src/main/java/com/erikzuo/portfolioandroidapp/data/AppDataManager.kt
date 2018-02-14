package com.erikzuo.portfolioandroidapp.data

import android.content.Context

import com.erikzuo.portfolioandroidapp.data.model.Education
import com.erikzuo.portfolioandroidapp.data.model.MyInfo
import com.erikzuo.portfolioandroidapp.data.model.Repo
import com.erikzuo.portfolioandroidapp.data.model.Work
import com.erikzuo.portfolioandroidapp.data.remote.GithubService
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.GenericTypeIndicator
import com.google.firebase.database.ValueEventListener

import javax.inject.Inject

import io.reactivex.Observable

/**
 * Created by YifanZuo on 4/2/18.
 */

class AppDataManager @Inject
constructor(private val context: Context, private val githubService: GithubService, private val firebaseDatabase: FirebaseDatabase) : DataManager {


    override val myInfo: Observable<MyInfo>
        get() = Observable.create { e ->
            firebaseDatabase.getReference("my_info")
                    .addValueEventListener(object : ValueEventListener {
                        override fun onDataChange(dataSnapshot: DataSnapshot) {
                            e.onNext(dataSnapshot.getValue<MyInfo>(MyInfo::class.java))
                        }

                        override fun onCancelled(databaseError: DatabaseError) {
                            e.onError(databaseError.toException().fillInStackTrace())
                        }
                    })
        }


    override val repoListApiCall: Observable<List<Repo>>
        get() = githubService.getRepos("silverend")

    override val educationList: Observable<List<Education>>
        get() = Observable.create { e ->
            firebaseDatabase.getReference("education")
                    .addValueEventListener(object : ValueEventListener {
                        override fun onDataChange(dataSnapshot: DataSnapshot) {
                            e.onNext(dataSnapshot.getValue(object : GenericTypeIndicator<List<Education>>() {

                            }))
                        }

                        override fun onCancelled(databaseError: DatabaseError) {

                        }
                    })
        }

//    override val workList: Observable<List<Work>>

}
