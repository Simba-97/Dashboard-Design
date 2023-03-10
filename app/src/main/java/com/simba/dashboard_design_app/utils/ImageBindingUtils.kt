package com.simba.dashboard_design_app.utils

import android.text.TextUtils
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load
import com.simba.dashboard_design_app.R

object BindingUtils {

    @BindingAdapter("profileIcon")
    fun loadAndBindImage(imageView: ImageView, url: String?) {
        if (!TextUtils.isEmpty(url)) {
            imageView.load(url) {
                placeholder(R.drawable.placeholder_image)
            }
        } else {
            imageView.load(R.drawable.placeholder_image)
        }
    }
}