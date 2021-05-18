package com.example.agricultural_products_store.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.agricultural_products_store.Model.ModelCart
import com.example.agricultural_products_store.R
import com.squareup.picasso.Picasso

class ViewPagerAdapter(private val images: List<ModelCart>):RecyclerView.Adapter<ViewPagerAdapter.ViewHolder>() {
    inner class ViewHolder(itemView : View): RecyclerView.ViewHolder(itemView) {
        val image = itemView.findViewById<ImageView>(R.id.imageProduct)
        val name = itemView.findViewById<TextView>(R.id.nameProduct)
        val numberCart =  itemView.findViewById<TextView>(R.id.numberCart)
        val addCart =  itemView.findViewById<ImageView>(R.id.addCart)
        val removeCart =  itemView.findViewById<ImageView>(R.id.removeCart)
        val price =  itemView.findViewById<TextView>(R.id.priceProduct)
        val totalPrice =  itemView.findViewById<TextView>(R.id.total_price)
        val deleteCart =  itemView.findViewById<ImageView>(R.id.deleteCart)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_cart,parent,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model : ModelCart? = images[position]
        Picasso.get().load(model?.image).into(holder.image)
        holder.name.text= model?.name
        holder.numberCart.text=model?.quantity.toString()
        holder.price.text=model?.price.toString()
        holder.totalPrice.text=model?.totalPrice.toString()
    }

    override fun getItemCount(): Int {
        return images.size
    }
}