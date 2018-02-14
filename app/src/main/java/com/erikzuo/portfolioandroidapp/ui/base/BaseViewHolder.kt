package com.erikzuo.portfolioandroidapp.ui.base

import android.support.v7.widget.RecyclerView
import android.view.View

/**
 * Created by Soprano on 8/02/2018.
 */

abstract class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    abstract fun onBind(position: Int)

}