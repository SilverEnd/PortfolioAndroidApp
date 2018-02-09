package com.erikzuo.portfolioandroidapp.data;

import com.erikzuo.portfolioandroidapp.data.model.Education;
import com.erikzuo.portfolioandroidapp.data.model.MyInfo;
import com.erikzuo.portfolioandroidapp.data.model.Repo;
import com.erikzuo.portfolioandroidapp.data.model.Work;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by YifanZuo on 3/2/18.
 */

public interface DataManager {

    Observable<MyInfo> getMyInfo();

    Observable<List<Repo>> getRepoListApiCall();

    Observable<List<Education>> getEducationList();

    Observable<List<Work>> getWorkList();
}
