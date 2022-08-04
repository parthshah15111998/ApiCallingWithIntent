package com.example.apicallingwithintent.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize // add kotlin-parcelize in gradleFile
data class MovieClassItem(
    val category: String,
    val desc: String,
    val imageUrl: String,
    val name: String
) : Parcelable