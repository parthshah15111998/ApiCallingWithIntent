package com.example.apicallingwithintent

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.apicallingwithintent.databinding.ItemRowBinding
import com.example.apicallingwithintent.model.MovieClassItem

class MovieAdapter(val context: Context,val movieList: List<MovieClassItem>):
    RecyclerView.Adapter<MovieAdapter.ViewHolder>() {
    class ViewHolder(val binding: ItemRowBinding):RecyclerView.ViewHolder(binding.root) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemRowBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.item = movieList[position]
        holder.itemView.setOnClickListener {
            /*if (position == 0){
                Toast.makeText(context,"This is First Movie",Toast.LENGTH_LONG).show()
            }
            if (position == 1){
                Toast.makeText(context,"This is Second Movie",Toast.LENGTH_LONG).show()
            }
            if (position == 2){
                Toast.makeText(context,"This is Three Movie",Toast.LENGTH_LONG).show()
            }
            if (position == 3){
                Toast.makeText(context,"This is Four Movie",Toast.LENGTH_LONG).show()
            }
            if (position == 4){
                Toast.makeText(context,"This is Five Movie",Toast.LENGTH_LONG).show()
            }*/

            val intent = Intent(context,MainActivity2::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            intent.putExtra("movieList",movieList[position])
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return movieList.size
    }
}