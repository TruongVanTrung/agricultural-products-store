package com.example.agricultural_products_store.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.agricultural_products_store.Model.ModelSlide
import com.example.agricultural_products_store.R

class ViewPagerAdapter(private val images : List<Int>):RecyclerView.Adapter<ViewPagerAdapter.ViewHolder>() {
    inner class ViewHolder(itemView : View): RecyclerView.ViewHolder(itemView) {
        val image : ImageView=itemView.findViewById(R.id.imageSlider)
        init {
            image.setOnClickListener {
                v: View ->
                val position = adapterPosition
                Toast.makeText(itemView.context,"You Clicked on slide #${position+1}",Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_slide,parent,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.image.setImageResource(images[position])
    }

    override fun getItemCount(): Int {
        return images.size
    }
}