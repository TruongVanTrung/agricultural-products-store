package com.example.agricultural_products_store.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.agricultural_products_store.Model.ModelProduct
import com.example.agricultural_products_store.R
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.squareup.picasso.Picasso

class ProductAdapter(options: FirestoreRecyclerOptions<ModelProduct>): FirestoreRecyclerAdapter<ModelProduct, ProductAdapter.ViewHolder>(
        options
) {
    class ViewHolder(itemView:View): RecyclerView.ViewHolder(itemView) {
        var image  = itemView.findViewById<ImageView>(R.id.imageCardProduct)
        var nameProduct = itemView.findViewById<TextView>(R.id.nameCardProduct)
        var price =itemView.findViewById<TextView>(R.id.priceCardProduct)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.card_product, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int, model: ModelProduct) {
        Picasso.get().load(model.image).into(holder.image)
        holder.nameProduct.text=model.name
        holder.price.text=model.price
    }
}