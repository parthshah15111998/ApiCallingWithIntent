package com.example.apicallingwithintent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apicallingwithintent.databinding.ActivityMainBinding
import com.example.apicallingwithintent.model.MovieClassItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://howtodoandroid.com/"
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var Adapter:MovieAdapter
    private lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        linearLayoutManager= LinearLayoutManager(this)
        binding.recyclerView.layoutManager=linearLayoutManager
        getMyData()
    }

    private fun getMyData() {

        val retrofitBuilder = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)

        val retrofitData =retrofitBuilder.getMovieList()

        retrofitData.enqueue(object : Callback<List<MovieClassItem>?> {
            override fun onResponse(
                call: Call<List<MovieClassItem>?>,
                response: Response<List<MovieClassItem>?>
            ) {
                val responseBody =response.body()!!
                Adapter = MovieAdapter(baseContext,responseBody)
                binding.recyclerView.adapter = Adapter
            }

            override fun onFailure(call: Call<List<MovieClassItem>?>, t: Throwable) {
                Log.d("MainActivity","onfailer"+t.message)
            }
        })
    }
}