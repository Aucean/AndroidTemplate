package com.aucean.vmtest.adapter;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by jie on 2017/3/20.
 */
public class MyViewHolder extends RecyclerView.ViewHolder
{
    private ViewDataBinding binding;
    private CommonRecyclerViewAdapter.OnItemClickListener mOnItemClickListener;
    public MyViewHolder(View itemView)
    {
        super(itemView);
    }
    public MyViewHolder(ViewDataBinding binding)
    {
        super(binding.getRoot());
        this.binding = binding;
    }
    public void setOnItemClickListener(CommonRecyclerViewAdapter.OnItemClickListener listener)
    {
        if (listener == null)
        {
            itemView.setOnClickListener(null);
            itemView.setOnLongClickListener(null);
            return;
        }
        mOnItemClickListener = listener;
        itemView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                int position  = MyViewHolder.this.getAdapterPosition();
                if (position < 0)
                    return;
                mOnItemClickListener.onClick(v, position);
            }
        });
        itemView.setOnLongClickListener(new View.OnLongClickListener()
        {
            @Override
            public boolean onLongClick(View v)
            {
                int position  = MyViewHolder.this.getAdapterPosition();
                if (position < 0)
                    return false;
                mOnItemClickListener.onLongClick(v, position);
                return false;
            }
        });
    }

    public void addViewClickListener(View v, final OnChildViewClickListener listener)
    {

        v.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                int position  = MyViewHolder.this.getAdapterPosition();
                if (position < 0)
                    return;
                listener.onClick(v, position);
            }
        });
    }
    public ViewDataBinding getBinding()
    {
        return binding;
    }

    public void setBinding(ViewDataBinding binding)
    {
        this.binding = binding;
    }

    public interface OnChildViewClickListener
    {
        void onClick(View v, int position);
    }
}