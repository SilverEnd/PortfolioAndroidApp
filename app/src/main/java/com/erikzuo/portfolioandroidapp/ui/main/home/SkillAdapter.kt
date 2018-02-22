package com.erikzuo.portfolioandroidapp.ui.main.home

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.erikzuo.portfolioandroidapp.data.model.Skill
import com.erikzuo.portfolioandroidapp.databinding.ItemSkillBinding
import com.erikzuo.portfolioandroidapp.ui.base.BaseViewHolder

/**
 * Created by Soprano on 22/02/2018.
 */
class SkillAdapter(private val mSkillList: MutableList<Skill>) : RecyclerView.Adapter<BaseViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val skillViewBinding = ItemSkillBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false)

        return SkillViewHolder(skillViewBinding)
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.onBind(position)
    }

    override fun getItemCount(): Int {
        return mSkillList.size
    }


    fun addItems(skills: List<Skill>) {
        mSkillList.addAll(skills)
        notifyDataSetChanged()
    }

    fun clearItems() {
        mSkillList.clear()
        notifyDataSetChanged()
    }


    inner class SkillViewHolder(private val mBinding: ItemSkillBinding) : BaseViewHolder(mBinding.root) {

        private lateinit var mViewModel: SkillItemVIewModel

        override fun onBind(position: Int) {
            val skill = mSkillList[position]
            mViewModel = SkillItemVIewModel(skill)

            mBinding.viewModel = mViewModel
            mBinding.executePendingBindings()
        }


    }


}