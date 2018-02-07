package com.erikzuo.portfolioandroidapp.data;

import android.content.Context;

import com.erikzuo.portfolioandroidapp.data.remote.GithubService;

import javax.inject.Inject;

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
}
