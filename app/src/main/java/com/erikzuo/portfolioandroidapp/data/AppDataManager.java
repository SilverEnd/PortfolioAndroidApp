package com.erikzuo.portfolioandroidapp.data;

import android.content.Context;

import com.erikzuo.portfolioandroidapp.data.model.Education;
import com.erikzuo.portfolioandroidapp.data.model.MyInfo;
import com.erikzuo.portfolioandroidapp.data.model.Repo;
import com.erikzuo.portfolioandroidapp.data.model.Work;
import com.erikzuo.portfolioandroidapp.data.remote.GithubService;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by YifanZuo on 4/2/18.
 */

public class AppDataManager implements DataManager {


    private final Context context;
    private GithubService githubService;
    private FirebaseDatabase firebaseDatabase;

    @Inject
    public AppDataManager(Context context, GithubService githubService, FirebaseDatabase firebaseDatabase) {
        this.context = context;
        this.githubService = githubService;
        this.firebaseDatabase = firebaseDatabase;
    }


    @Override
    public Observable<MyInfo> getMyInfo() {
        return Observable.create(
                e -> firebaseDatabase.getReference("my_info")
                        .addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                e.onNext(dataSnapshot.getValue(MyInfo.class));
                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {
                                e.onError(databaseError.toException().fillInStackTrace());
                            }
                        }));
    }


    @Override
    public Observable<List<Repo>> getRepoListApiCall() {
        return githubService.getRepos("silverend");
    }

    @Override
    public Observable<List<Education>> getEducationList() {
        return Observable.create(
                e -> firebaseDatabase.getReference("education")
                        .addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                e.onNext(dataSnapshot.getValue(new GenericTypeIndicator<List<Education>>(){}));
                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        })
        );
    }

    @Override
    public Observable<List<Work>> getWorkList() {
        return null;
    }

}
