package com.erikzuo.portfolioandroidapp.ui.main.work;

import android.arch.lifecycle.MutableLiveData;
import android.databinding.ObservableArrayList;

import com.erikzuo.portfolioandroidapp.data.DataManager;
import com.erikzuo.portfolioandroidapp.data.model.Repo;
import com.erikzuo.portfolioandroidapp.ui.base.BaseViewModel;
import com.erikzuo.portfolioandroidapp.utils.rx.SchedulerProvider;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.functions.Consumer;

/**
 * Created by Soprano on 7/02/2018.
 */

public class WorkViewModel extends BaseViewModel<WorkNavigator> {

    private final ObservableArrayList<Repo> repoList = new ObservableArrayList<>();

    @Inject
    public WorkViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);

        loadRepos();
    }

    public void loadRepos() {
        setIsLoading(true);
        getCompositeDisposable().add(getDataManager()
                .getRepoListApiCall()
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(
                        repos -> {
                            repoList.addAll(repos);
                            setIsLoading(false);
                        }
                )
        );
    }

    public ObservableArrayList<Repo> getRepoList() {
        return repoList;
    }

}
