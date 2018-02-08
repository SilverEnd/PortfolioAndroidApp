package com.erikzuo.portfolioandroidapp.ui.main.work;

import android.arch.lifecycle.MutableLiveData;
import android.databinding.ObservableArrayList;

import com.erikzuo.portfolioandroidapp.data.DataManager;
import com.erikzuo.portfolioandroidapp.data.model.Repo;
import com.erikzuo.portfolioandroidapp.ui.base.BaseViewModel;
import com.erikzuo.portfolioandroidapp.utils.rx.SchedulerProvider;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Soprano on 7/02/2018.
 */

public class WorkViewModel extends BaseViewModel<WorkNavigator> {

    private final MutableLiveData<List<Repo>> reposLiveData = new MutableLiveData<>();
    private final ObservableArrayList<Repo> repoList = new ObservableArrayList<>();

    @Inject
    public WorkViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);

        loadRepos();
    }

    public void loadRepos() {
        getCompositeDisposable().add(getDataManager()
                .getRepoListApiCall()
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(
                        reposLiveData::setValue
                )
        );
    }

    public MutableLiveData<List<Repo>> getReposLiveData() {
        return reposLiveData;
    }

    public ObservableArrayList<Repo> getRepoList() {
        return repoList;
    }

    public void addRepos(List<Repo> repos) {
        repoList.clear();
        repoList.addAll(repos);
    }
}
