package com.example.apicallingwithintent

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("imageUrl")  // add kotlin-kapt in gradle file
fun ImageView.imageUrl(avater_Url:String?) {

    Glide.with(context).load(avater_Url).into(this)
}