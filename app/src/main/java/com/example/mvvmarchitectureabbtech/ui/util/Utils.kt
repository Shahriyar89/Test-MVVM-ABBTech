package com.example.mvvmarchitectureabbtech.ui.util

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.mvvmarchitectureabbtech.ui.AbbActivity

@BindingAdapter("paddingLeft")
fun setPaddingLeft(view: ImageView, url: String) {
    Glide.with(view.context)
        .load(url)
        .into(view)
}