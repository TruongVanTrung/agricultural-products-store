package com.example.agricultural_products_store.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.agricultural_products_store.Adapter.CategoryAdapter
import com.example.agricultural_products_store.Adapter.ProductAdapter
import com.example.agricultural_products_store.Model.ModelCategory
import com.example.agricultural_products_store.Model.ModelProduct
import com.example.agricultural_products_store.R
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ShowProductFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ShowProductFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    var productAdapter : ProductAdapter?=null
    private val db: FirebaseFirestore = FirebaseFirestore.getInstance()
    private lateinit var auth: FirebaseAuth
    private lateinit var fireStore : FirebaseFirestore
    private lateinit var reference : DatabaseReference
    private val collectionReference : CollectionReference = db.collection("products")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    @SuppressLint("WrongConstant")
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_show_product, container, false)

        var idcategoryy = arguments?.getString("idCategoryy")
        var idcategoryyy = arguments?.getString("idCategoryyy")
        if (idcategoryy!=null) {
            var recyclerView = view.findViewById<RecyclerView>(R.id.recyclerShowProduct)
            val query: Query = collectionReference.whereEqualTo("idCategory", idcategoryy)
            val firestoreRecyclerOptions: FirestoreRecyclerOptions<ModelProduct> = FirestoreRecyclerOptions.Builder<ModelProduct>()
                    .setQuery(query, ModelProduct::class.java)
                    .build()
            productAdapter = ProductAdapter(firestoreRecyclerOptions)
            recyclerView.layoutManager = LinearLayoutManager(activity, LinearLayout.HORIZONTAL, false)
            recyclerView.adapter = productAdapter
        }
//        if (idcategoryyy!=null) {
//            var recyclerView = view.findViewById<RecyclerView>(R.id.recyclerShowProduct)
//            val query: Query = collectionReference.whereEqualTo("idCategory", idcategoryyy)
//            val firestoreRecyclerOptions: FirestoreRecyclerOptions<ModelProduct> = FirestoreRecyclerOptions.Builder<ModelProduct>()
//                    .setQuery(query, ModelProduct::class.java)
//                    .build()
//            productAdapter = ProductAdapter(firestoreRecyclerOptions)
//            recyclerView.layoutManager = LinearLayoutManager(activity, LinearLayout.HORIZONTAL, false)
//            recyclerView.adapter = productAdapter
//        }
        return view
    }
    override fun onStart() {
        super.onStart()
        productAdapter!!.startListening()
    }

    override fun onDestroy() {
        super.onDestroy()
        productAdapter!!.stopListening()
    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ShowProductFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                ShowProductFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
}