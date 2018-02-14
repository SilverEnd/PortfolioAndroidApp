package com.erikzuo.portfolioandroidapp.ui.main.education

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

import com.erikzuo.portfolioandroidapp.data.model.Education
import com.erikzuo.portfolioandroidapp.databinding.ItemEducationBinding
import com.erikzuo.portfolioandroidapp.ui.base.BaseViewHolder

/**
 * Created by Soprano on 9/02/2018.
 */

class EducationAdapter(private val mEducationList: MutableList<Education>) : RecyclerView.Adapter<BaseViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val educationViewBinding = ItemEducationBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false)

        return EducationViewHolder(educationViewBinding)
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.onBind(position)
    }

    override fun getItemCount(): Int {
        return mEducationList.size
    }


    fun addItems(educationList: List<Education>) {
        mEducationList.addAll(educationList)
        notifyDataSetChanged()
    }

    fun clearItems() {
        mEducationList.clear()
        notifyDataSetChanged()
    }


    inner class EducationViewHolder(private val mBinding: ItemEducationBinding) : BaseViewHolder(mBinding.root) {
        private var mViewModel: EducationItemViewModel? = null


        override fun onBind(position: Int) {
            val education = mEducationList[position]

            mViewModel = EducationItemViewModel(education)

            mBinding.viewModel = mViewModel

            mBinding.executePendingBindings()
        }
    }
}
