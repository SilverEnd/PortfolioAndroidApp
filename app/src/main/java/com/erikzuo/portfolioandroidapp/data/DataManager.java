package com.erikzuo.portfolioandroidapp.data;

import android.arch.lifecycle.LiveData;

import com.erikzuo.portfolioandroidapp.data.model.Repo;
import com.erikzuo.portfolioandroidapp.data.remote.ApiResponse;

import java.util.List;

/**
 * Created by YifanZuo on 3/2/18.
 */

public interface DataManager {

    String getName();

    String getEmail();

    LiveData<ApiResponse<List<Repo>>> getRepo
}
