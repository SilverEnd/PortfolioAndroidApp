package com.erikzuo.portfolioandroidapp.utils;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;

import com.erikzuo.portfolioandroidapp.data.model.Education;
import com.erikzuo.portfolioandroidapp.data.model.Repo;
import com.erikzuo.portfolioandroidapp.ui.main.education.EducationAdapter;
import com.erikzuo.portfolioandroidapp.ui.main.work.personal.RepoAdapter;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Soprano on 6/02/2018.
 */

public class BindingUtils {

    @BindingAdapter("imageUrl")
    public static void setImageUrl(ImageView imageView, String url) {
        if (url == null) {
            imageView.setImageDrawable(null);
        } else {
            Log.d("imageurl", url);
            Picasso.with(imageView.getContext())
                    .load(url)
                    .into(imageView);
        }
    }


    @BindingAdapter({"adapter"})
    public static void addRepoItems(RecyclerView recyclerView,
                                    ArrayList<Repo> repos) {
        RepoAdapter adapter = (RepoAdapter) recyclerView.getAdapter();
        if (adapter != null) {
            adapter.clearItems();
            adapter.addItems(repos);
        }
    }


    @BindingAdapter({"adapter"})
    public static void addEducationItems(RecyclerView recyclerView,
                                    ArrayList<Education> educations) {
        EducationAdapter adapter = (EducationAdapter) recyclerView.getAdapter();
        if (adapter != null) {
            adapter.clearItems();
            adapter.addItems(educations);
        }
    }

}
