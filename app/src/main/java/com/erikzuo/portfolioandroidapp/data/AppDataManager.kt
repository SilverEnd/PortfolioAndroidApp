package com.erikzuo.portfolioandroidapp.data

import android.content.Context
import com.erikzuo.portfolioandroidapp.data.model.*

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

    private lateinit var myInfo: Observable<MyInfo>

    override fun getMyInfo(): Observable<MyInfo> {
        if (myInfo == null) {
            myInfo = Observable.create { e ->
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
        }

        return myInfo
    }


    override fun getRepoListApiCall(): Observable<List<Repo>> {
        return githubService.getRepos("silverend")
    }


    override fun getEducationList(): Observable<List<Education>> {
        return Observable.create { e ->
            firebaseDatabase.getReference("education")
                    .addValueEventListener(object : ValueEventListener {
                        override fun onDataChange(dataSnapshot: DataSnapshot) {
                            e.onNext(dataSnapshot.getValue(object : GenericTypeIndicator<List<@JvmSuppressWildcards Education>>() {}))
                        }

                        override fun onCancelled(databaseError: DatabaseError) {

                        }
                    })
        }
    }

    override fun getSkillList(): Observable<List<Skill>> {
        return Observable.create { e ->
            firebaseDatabase.getReference("skills")
                    .addValueEventListener(object : ValueEventListener {
                        override fun onDataChange(dataSnapshot: DataSnapshot) {
                            e.onNext(dataSnapshot.getValue(object : GenericTypeIndicator<List<@JvmSuppressWildcards Skill>>() {}))
                        }

                        override fun onCancelled(databaseError: DatabaseError) {

                        }
                    })
        }

    }
}
