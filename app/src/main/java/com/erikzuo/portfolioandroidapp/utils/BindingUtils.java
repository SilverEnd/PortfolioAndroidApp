package com.erikzuo.portfolioandroidapp.utils;

import android.databinding.BindingAdapter;
import android.util.Log;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

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
}
