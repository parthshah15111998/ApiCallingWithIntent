package com.example.apicallingwithintent

import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.apicallingwithintent.databinding.ActivityMain2Binding
import com.example.apicallingwithintent.model.MovieClassItem

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        var intent = intent

        var  list = intent.getParcelableExtra<MovieClassItem>("movieList")

            Glide.with(applicationContext).load(list?.imageUrl).into(binding.imgImags)
            binding.tvMovieName.text = list?.name
            binding.tvMovieCategory.text = list?.desc



    }
}