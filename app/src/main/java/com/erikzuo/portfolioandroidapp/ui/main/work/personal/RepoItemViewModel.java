package com.erikzuo.portfolioandroidapp.ui.main.work.personal;

import android.databinding.ObservableField;

import com.erikzuo.portfolioandroidapp.data.DataManager;
import com.erikzuo.portfolioandroidapp.data.model.Repo;
import com.erikzuo.portfolioandroidapp.ui.base.BaseViewModel;
import com.erikzuo.portfolioandroidapp.utils.rx.SchedulerProvider;

import javax.inject.Inject;

/**
 * Created by Soprano on 8/02/2018.
 */

public class RepoItemViewModel{

    private Repo mRepo;
    public ObservableField<String> name;

    public RepoItemViewModel(Repo repo) {
        this.mRepo = repo;

        name = new ObservableField<>(mRepo.getName());
    }
}
