package com.erikzuo.portfolioandroidapp.ui.main.work.personal;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.erikzuo.portfolioandroidapp.data.model.Repo;
import com.erikzuo.portfolioandroidapp.databinding.RepoItemBinding;
import com.erikzuo.portfolioandroidapp.ui.base.BaseViewHolder;

import java.util.List;

/**
 * Created by Soprano on 8/02/2018.
 */

public class RepoAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private List<Repo> mRepoList;


    public RepoAdapter(List<Repo> repoList) {
        this.mRepoList = repoList;
    }


    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RepoItemBinding repoViewBinding = RepoItemBinding.inflate(
                LayoutInflater.from(parent.getContext()),
                parent,
                false);

        return new RepoViewHolder(repoViewBinding);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public int getItemCount() {
        return mRepoList.size();
    }


    public void addItems(List<Repo> repoList) {
        mRepoList.addAll(repoList);
        notifyDataSetChanged();
    }

    public void clearItems() {
        mRepoList.clear();
        notifyDataSetChanged();
    }


    public class RepoViewHolder extends BaseViewHolder {

        private RepoItemBinding mBinding;

        private RepoItemViewModel mViewModel;

        public RepoViewHolder(RepoItemBinding binding) {
            super(binding.getRoot());
            this.mBinding = binding;
        }

        @Override
        public void onBind(int position) {

            final Repo repo = mRepoList.get(position);

            mViewModel = new RepoItemViewModel(repo);

            mBinding.setViewModel(mViewModel);

            // Immediate Binding
            // When a variable or observable changes, the binding will be scheduled to change before
            // the next frame. There are times, however, when binding must be executed immediately.
            // To force execution, use the executePendingBindings() method.
            mBinding.executePendingBindings();

        }

    }

}
