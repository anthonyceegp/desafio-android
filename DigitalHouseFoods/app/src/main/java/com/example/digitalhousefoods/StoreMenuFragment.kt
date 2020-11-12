package com.example.digitalhousefoods

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class StoreMenuFragment : Fragment(), OnDishClickListener {

    private lateinit var recycler: RecyclerView
    private lateinit var navController: NavController
    private val store by lazy { arguments?.getParcelable<Store>("STORE") }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_store_menu, container, false)

        recycler = view.findViewById(R.id.recyclerview_menu)
        recycler.setHasFixedSize(true)
        recycler.layoutManager = GridLayoutManager(view.context, 2)
        recycler.adapter = StoreMenuAdapter(store!!.dishList, this)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as MainActivity).changeToolbar(store!!.name, true)

        navController = Navigation.findNavController(view)
    }

    override fun onDishClick(position: Int) {
        val bundle = Bundle()
        bundle.putParcelable("DISH", store!!.dishList[position])
        navController.navigate(R.id.dishDetailFragment, bundle)
    }
}