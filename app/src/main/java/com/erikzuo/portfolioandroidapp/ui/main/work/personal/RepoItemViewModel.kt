package com.erikzuo.portfolioandroidapp.ui.main.work.personal

import android.content.Intent
import android.databinding.ObservableField
import android.net.Uri

import com.erikzuo.portfolioandroidapp.data.DataManager
import com.erikzuo.portfolioandroidapp.data.model.Repo
import com.erikzuo.portfolioandroidapp.ui.base.BaseViewModel
import com.erikzuo.portfolioandroidapp.utils.rx.SchedulerProvider

import javax.inject.Inject

/**
 * Created by Soprano on 8/02/2018.
 */

class RepoItemViewModel(private val mRepo: Repo, private var mListener: RepoItemListener?) {

    var title: ObservableField<String?> = ObservableField(mRepo.name)
    var content: ObservableField<String?> = ObservableField(mRepo.description)

    interface RepoItemListener {
        fun onItemClick(url: String?)
    }

    fun onItemClick() {
        if (mListener != null)
            mListener!!.onItemClick(mRepo.link)
    }
}
