package com.erikzuo.portfolioandroidapp.ui.main.work.personal;

import android.content.Intent;
import android.databinding.ObservableField;
import android.net.Uri;

import com.erikzuo.portfolioandroidapp.data.DataManager;
import com.erikzuo.portfolioandroidapp.data.model.Repo;
import com.erikzuo.portfolioandroidapp.ui.base.BaseViewModel;
import com.erikzuo.portfolioandroidapp.utils.rx.SchedulerProvider;

import javax.inject.Inject;

/**
 * Created by Soprano on 8/02/2018.
 */

public class RepoItemViewModel {
    public interface RepoItemListener {
        void onItemClick(String url);
    }


    private Repo mRepo;
    public RepoItemListener mListener;

    public ObservableField<String> title;
    public ObservableField<String> content;

    public RepoItemViewModel(Repo repo, RepoItemListener listener) {
        this.mRepo = repo;
        this.mListener = listener;

        title = new ObservableField<>(mRepo.getName());
        content = new ObservableField<>(mRepo.getDescription());
    }

    public void onItemClick() {
        if (mListener != null)
            mListener.onItemClick(mRepo.getLink());
    }
}
