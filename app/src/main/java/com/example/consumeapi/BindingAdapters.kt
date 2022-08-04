package com.example.consumeapi

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("showImage")
fun showImage(imgView : ImageView , url : String?){
    Glide.with(imgView.context)
        .load(url)
        .into(imgView)

}