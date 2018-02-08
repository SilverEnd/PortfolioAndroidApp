package com.erikzuo.portfolioandroidapp.data;

import android.arch.lifecycle.LiveData;
import android.content.Context;

import com.erikzuo.portfolioandroidapp.data.model.Repo;
import com.erikzuo.portfolioandroidapp.data.remote.ApiResponse;
import com.erikzuo.portfolioandroidapp.data.remote.GithubService;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by YifanZuo on 4/2/18.
 */

public class AppDataManager implements DataManager {


    private final Context context;
    private GithubService githubService;

    @Inject
    public AppDataManager(Context context, GithubService githubService) {
        this.context = context;
        this.githubService = githubService;
    }

    @Override
    public String getName() {
        return "Erik Zuo";
    }

    @Override
    public String getEmail() {
        return null;
    }

    @Override
    public Observable<ApiResponse<List<Repo>>> getRepos() {
        return githubService.getRepos("silverend");
    }
}
