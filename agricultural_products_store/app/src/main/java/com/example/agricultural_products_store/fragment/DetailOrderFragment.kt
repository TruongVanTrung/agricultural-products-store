package com.example.agricultural_products_store.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.agricultural_products_store.Adapter.CartAdapter
import com.example.agricultural_products_store.Adapter.DetailPaymentAdapter
import com.example.agricultural_products_store.Model.ModelCart
import com.example.agricultural_products_store.Model.ModelDetailPayment
import com.example.agricultural_products_store.R
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DetailOrderFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DetailOrderFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var auth: FirebaseAuth
    private lateinit var fireStore : FirebaseFirestore
    private val db: FirebaseFirestore = FirebaseFirestore.getInstance()
    private val collectionReference : CollectionReference = db.collection("detailPayment")
    var detailPaymentAdapter : DetailPaymentAdapter?=null


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
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_detail_order, container, false)
        var idPayment = arguments?.getString("idPayment")
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerViewDetail)
        fireStore = FirebaseFirestore.getInstance()
        val query : Query = collectionReference.whereEqualTo("idPayment",idPayment)
        val firestoreRecyclerOptionsCart: FirestoreRecyclerOptions<ModelDetailPayment> = FirestoreRecyclerOptions.Builder<ModelDetailPayment>()
            .setQuery(query, ModelDetailPayment::class.java)
            .build()
        detailPaymentAdapter = DetailPaymentAdapter(firestoreRecyclerOptionsCart)
        recyclerView.layoutManager= LinearLayoutManager(activity, LinearLayout.VERTICAL, false)
        recyclerView.adapter= detailPaymentAdapter


        return view
    }

    override fun onStart() {
        super.onStart()
        detailPaymentAdapter!!.startListening()
    }

    override fun onDestroy() {
        super.onDestroy()
        detailPaymentAdapter!!.stopListening()
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment DetailOrderFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            DetailOrderFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}