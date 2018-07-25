package com.aucean.vmtest.adapter


import android.app.Activity
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.view.ViewGroup
import com.aucean.vmtest.BR

import java.util.ArrayList

/**
 * Created by jie on 2017/2/23.
 */

class CommonRecyclerViewAdapter<T>(val mActivity: Activity, dataList: List<T>?, val mLayoutId: Int) : RecyclerView.Adapter<MyViewHolder>() {
    private val mData: List<T>
    private var mOnItemClickListener: OnItemClickListener? = null

    init {
        if (dataList == null) {
            mData = ArrayList()
        } else {
            mData = dataList
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): MyViewHolder {
        val viewDataBinding = DataBindingUtil.inflate<ViewDataBinding>(mActivity.layoutInflater, mLayoutId, viewGroup, false)
        val viewHolder = MyViewHolder(viewDataBinding.root)
        viewHolder.setBinding(viewDataBinding)
        if (mOnItemClickListener != null) {
            viewHolder.setOnItemClickListener(mOnItemClickListener)
        }
        return viewHolder
    }

    override fun onBindViewHolder(customViewHolder: MyViewHolder, i: Int) {
        val viewDataBinding = customViewHolder.getBinding()
        viewDataBinding.setVariable(BR.dataModel, mData[i])
        viewDataBinding.executePendingBindings()
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        mOnItemClickListener = listener
    }

    fun getmOnItemClickListener(): CommonRecyclerViewAdapter.OnItemClickListener? {
        return mOnItemClickListener
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    fun getItem(position: Int): T {
        return mData[position]
    }

    interface OnItemClickListener {
        fun onClick(v: View, position: Int)
        fun onLongClick(v: View, position: Int): Boolean
    }

}
