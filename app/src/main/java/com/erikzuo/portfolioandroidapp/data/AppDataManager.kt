package com.erikzuo.portfolioandroidapp.data

import android.content.Context
import android.util.Log
import com.erikzuo.portfolioandroidapp.data.model.Education
import com.erikzuo.portfolioandroidapp.data.model.MyInfo
import com.erikzuo.portfolioandroidapp.data.model.Repo
import com.erikzuo.portfolioandroidapp.data.model.Skill
import com.erikzuo.portfolioandroidapp.data.remote.GithubService
import com.google.firebase.database.*
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by YifanZuo on 4/2/18.
 */

class AppDataManager @Inject
constructor(private val context: Context, private val githubService: GithubService, private val firebaseDatabase: FirebaseDatabase) : DataManager {


    override fun getMyInfo(): Observable<MyInfo> {
        return Observable.create { e ->
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
                            e.onError(databaseError.toException().fillInStackTrace())

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
                            e.onError(databaseError.toException().fillInStackTrace())
                        }
                    })
        }

    }
}
