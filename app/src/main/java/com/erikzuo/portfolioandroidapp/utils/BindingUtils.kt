package com.erikzuo.portfolioandroidapp.utils

import android.animation.ObjectAnimator
import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import android.widget.ImageView

import com.erikzuo.portfolioandroidapp.data.model.Education
import com.erikzuo.portfolioandroidapp.data.model.Repo
import com.erikzuo.portfolioandroidapp.ui.main.education.EducationAdapter
import com.erikzuo.portfolioandroidapp.ui.main.work.personal.RepoAdapter
import com.mikhaellopez.circularprogressbar.CircularProgressBar
import com.squareup.picasso.Picasso

import java.util.ArrayList
import android.view.animation.DecelerateInterpolator
import com.erikzuo.portfolioandroidapp.data.model.Skill
import com.erikzuo.portfolioandroidapp.ui.main.home.SkillAdapter


/**
 * Created by YifanZuo on 6/02/2018.
 */

object BindingUtils {

    @JvmStatic
    @BindingAdapter("imageUrl")
    fun setImageUrl(imageView: ImageView, url: String?) {
        if (url == null) {
            imageView.setImageDrawable(null)
        } else {
            Picasso.with(imageView.context)
                    .load(url)
                    .into(imageView)
        }
    }


    @JvmStatic
    @BindingAdapter("adapter")
    fun addRepoItems(recyclerView: RecyclerView,
                     repos: ArrayList<Repo>) {
        val adapter = recyclerView.adapter as RepoAdapter?

        adapter?.clearItems()
        adapter?.addItems(repos)
    }

    @JvmStatic
    @BindingAdapter("adapter")
    fun addEducationItems(recyclerView: RecyclerView,
                          educations: ArrayList<Education>) {
        val adapter = recyclerView.adapter as EducationAdapter?

        adapter?.clearItems()
        adapter?.addItems(educations)
    }


    @JvmStatic
    @BindingAdapter("adapter")
    fun addSkillItems(recyclerView: RecyclerView,
                          skills: List<Skill>) {
        val adapter = recyclerView.adapter as SkillAdapter?

        adapter?.clearItems()
        adapter?.addItems(skills)
    }

    @JvmStatic
    @BindingAdapter("progress")
    fun setProgress(progressView: CircularProgressBar, value: Float) {
        val animator: ObjectAnimator = ObjectAnimator.ofFloat(progressView, "progress", 0f, value)
        animator.duration = 1000
        animator.interpolator = DecelerateInterpolator()
        animator.start()
    }
}
