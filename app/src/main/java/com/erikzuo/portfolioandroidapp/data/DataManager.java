package com.erikzuo.portfolioandroidapp.data;

import com.erikzuo.portfolioandroidapp.data.model.Repo;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by YifanZuo on 3/2/18.
 */

public interface DataManager {

    String getName();

    String getEmail();

    Observable<List<Repo>> getRepoListApiCall();
}
