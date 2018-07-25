package com.aucean.vmtest.adapter

import android.databinding.BindingAdapter
import android.net.Uri
import android.text.TextUtils
import android.widget.ImageView
import com.squareup.picasso.Picasso

object DataBindingAdapter {

    @BindingAdapter("loadUrl")
    @JvmStatic fun setImageResource(imageView: ImageView, url: String?)
    {
        if (!TextUtils.isEmpty(url)) {
//            imageView.setImageURI(Uri.parse(url), imageView.context)
            Picasso.get().load(url).into(imageView)
        }
    }
}