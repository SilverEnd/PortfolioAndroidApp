package com.erikzuo.portfolioandroidapp.data;

import android.content.Context;

import javax.inject.Inject;

/**
 * Created by YifanZuo on 4/2/18.
 */

public class AppDataManager implements DataManager {

    private final Context mContext;


    @Inject
    public AppDataManager(Context context) {
        mContext = context;
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
