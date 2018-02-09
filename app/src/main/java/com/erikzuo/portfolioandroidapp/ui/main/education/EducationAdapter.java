package com.erikzuo.portfolioandroidapp.ui.main.education;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.erikzuo.portfolioandroidapp.data.model.Education;
import com.erikzuo.portfolioandroidapp.data.model.Repo;
import com.erikzuo.portfolioandroidapp.databinding.ItemEducationBinding;
import com.erikzuo.portfolioandroidapp.ui.base.BaseViewHolder;

import java.util.List;

/**
 * Created by Soprano on 9/02/2018.
 */

public class EducationAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private List<Education> mEducationList;

    public EducationAdapter(List<Education> educations) {
        this.mEducationList = educations;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemEducationBinding educationViewBinding = ItemEducationBinding.inflate(
                LayoutInflater.from(parent.getContext()),
                parent,
                false);

        return new EducationViewHolder(educationViewBinding);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public int getItemCount() {
        return mEducationList.size();
    }


    public void addItems(List<Education> educationList) {
        mEducationList.addAll(educationList);
        notifyDataSetChanged();
    }

    public void clearItems() {
        mEducationList.clear();
        notifyDataSetChanged();
    }


    public class EducationViewHolder extends BaseViewHolder {

        private ItemEducationBinding mBinding;
        private EducationItemViewModel mViewModel;

        public EducationViewHolder(ItemEducationBinding binding) {
            super(binding.getRoot());
            this.mBinding = binding;
        }


        @Override
        public void onBind(int position) {
            final Education education = mEducationList.get(position);

            mViewModel = new EducationItemViewModel(education);

            mBinding.setViewModel(mViewModel);

            // Immediate Binding
            // When a variable or observable changes, the binding will be scheduled to change before
            // the next frame. There are times, however, when binding must be executed immediately.
            // To force execution, use the executePendingBindings() method.
            mBinding.executePendingBindings();
        }
    }
}
