package com.example.agricultural_products_store.Adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.agricultural_products_store.Model.ModelCart
import com.example.agricultural_products_store.Model.ModelDetailPayment
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions

class DetailPaymentAdapter(options: FirestoreRecyclerOptions<ModelDetailPayment>): FirestoreRecyclerAdapter<ModelDetailPayment, DetailPaymentAdapter.ViewHolder>(
        options
) {
    class ViewHolder (itemView: View): RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int, model: ModelDetailPayment) {
        TODO("Not yet implemented")
    }
}