package com.erikzuo.portfolioandroidapp.ui.base;

import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;


import com.erikzuo.portfolioandroidapp.data.DataManager;
import com.erikzuo.portfolioandroidapp.data.model.MyInfo;
import com.erikzuo.portfolioandroidapp.utils.rx.SchedulerProvider;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by YifanZuo on 3/2/18.
 */

public abstract class BaseViewModel<N> extends ViewModel {

    private N mNavigator;
    private final DataManager mDataManager;
    private final SchedulerProvider mSchedulerProvider;

    private final ObservableField<String> mPageTitle = new ObservableField<>();
    private final ObservableBoolean mIsLoading = new ObservableBoolean(false);
    private final ObservableField<MyInfo> mMyInfo = new ObservableField<>(    );

    private CompositeDisposable mCompositeDisposable;

    public BaseViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        this.mDataManager = dataManager;
        this.mSchedulerProvider = schedulerProvider;
        this.mCompositeDisposable = new CompositeDisposable();

        mMyInfo.set(new MyInfo("Erik Zuo", "yifan1031@gmail.com", "Mobile Engineer", "https://avatars0.githubusercontent.com/u/5491995?s=400&v=4"));
    }

    public void setNavigator(N navigator) {
        this.mNavigator = navigator;
    }

    public N getNavigator() {
        return mNavigator;
    }

    public DataManager getDataManager() {
        return mDataManager;
    }

    public SchedulerProvider getSchedulerProvider() {
        return mSchedulerProvider;
    }

    public CompositeDisposable getCompositeDisposable() {
        return mCompositeDisposable;
    }

    public ObservableBoolean getIsLoading() {
        return mIsLoading;
    }

    public void setIsLoading(boolean isLoading) {
        mIsLoading.set(isLoading);
    }

    public ObservableField<String> getPageTitle() {
        return mPageTitle;
    }

    public void setPageTitle(String title){
        mPageTitle.set(title);
    }

    public ObservableField<MyInfo> getMyInfo() {
        return mMyInfo;
    }


    @Override
    protected void onCleared() {
        mCompositeDisposable.dispose();
        super.onCleared();
    }
}
