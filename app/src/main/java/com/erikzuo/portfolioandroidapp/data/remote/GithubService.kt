package com.erikzuo.portfolioandroidapp.data.remote

/**
 * Created by YifanZuo on 7/02/2018.
 */

import com.erikzuo.portfolioandroidapp.data.model.Repo

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Github REST API access points
 */
interface GithubService {

    @GET("/users/{username}/repos")
    fun getRepos(@Path("username") username: String): Observable<List<Repo>>
}
