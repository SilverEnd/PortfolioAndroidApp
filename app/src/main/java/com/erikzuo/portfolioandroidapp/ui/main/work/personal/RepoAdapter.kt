package com.erikzuo.portfolioandroidapp.ui.main.work.personal

import android.content.Intent
import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

import com.erikzuo.portfolioandroidapp.data.model.Repo
import com.erikzuo.portfolioandroidapp.databinding.ItemRepoBinding
import com.erikzuo.portfolioandroidapp.ui.base.BaseViewHolder

/**
 * Created by YifanZuo on 8/02/2018.
 */

class RepoAdapter(private val mRepoList: MutableList<Repo>) : RecyclerView.Adapter<BaseViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val repoViewBinding = ItemRepoBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false)

        return RepoViewHolder(repoViewBinding)
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.onBind(position)
    }

    override fun getItemCount(): Int {
        return mRepoList.size
    }


    fun addItems(repoList: List<Repo>) {
        mRepoList.addAll(repoList)
        notifyDataSetChanged()
    }

    fun clearItems() {
        mRepoList.clear()
        notifyDataSetChanged()
    }


    inner class RepoViewHolder(private val mBinding: ItemRepoBinding) : BaseViewHolder(mBinding.root), RepoItemViewModel.RepoItemListener {


        private lateinit var mViewModel: RepoItemViewModel

        override fun onBind(position: Int) {
            val repo = mRepoList[position]
            mViewModel = RepoItemViewModel(repo, this)

            mBinding.viewModel = mViewModel
            mBinding.executePendingBindings()
        }

        override fun onItemClick(url: String?) {
            if (url != null) {
                val intent = Intent()
                intent.action = Intent.ACTION_VIEW
                intent.addCategory(Intent.CATEGORY_BROWSABLE)
                intent.data = Uri.parse(url)
                itemView.context.startActivity(intent)
            }
        }

    }

}
