package com.erikzuo.portfolioandroidapp.data.remote;

/**
 * Created by Soprano on 7/02/2018.
 */

import android.arch.lifecycle.LiveData;

import com.erikzuo.portfolioandroidapp.data.model.Repo;

import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Github REST API access points
 */
public interface GithubService {

    @GET("/users/{username}/repos")
    LiveData<ApiResponse<Repo>> getRepos(@Path("username") String username);
}
