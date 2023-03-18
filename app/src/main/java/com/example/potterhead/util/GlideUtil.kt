package com.example.potterhead.util

import android.webkit.URLUtil
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.potterhead.R

object GlideUtil {

    fun loadImage(imageUrl: String, imageView: ImageView) {
        if (URLUtil.isValidUrl(imageUrl)) {
            Glide
                .with(imageView)
                .load(imageUrl)
                .placeholder(R.drawable.placeholder_portrait)
                .into(imageView)
        }
    }
}