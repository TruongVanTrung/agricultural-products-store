package com.example.agricultural_products_store.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.agricultural_products_store.Model.ModelCategory
import com.example.agricultural_products_store.R
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.squareup.picasso.Picasso
import org.w3c.dom.Text

class CategoryAdapter(options: FirestoreRecyclerOptions<ModelCategory>) : FirestoreRecyclerAdapter<ModelCategory, CategoryAdapter.ViewHolder>(
    options
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.card_category,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int, model: ModelCategory) {
        holder.nameCategory.text=model.name_category
        Picasso.get().load(model.image).into(holder.image)
    }

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        var image  = itemView.findViewById<ImageView>(R.id.imageCardCategory)
        var nameCategory = itemView.findViewById<TextView>(R.id.textCardCategory)
    }
}