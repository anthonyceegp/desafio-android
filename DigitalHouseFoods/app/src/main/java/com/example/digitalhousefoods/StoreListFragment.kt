package com.example.digitalhousefoods

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class StoreListFragment : Fragment(), OnStoreClickListener {
    private lateinit var recycler: RecyclerView
    private lateinit var navController: NavController
    private val storeList = listOf(
        Store(
            R.drawable.store_image, "Loja 1", "Endereço 1", "00:00",
            listOf(
                Dish(R.drawable.dish_image, "Dish 1", "Description 1"),
                Dish(R.drawable.dish_image, "Dish 2", "Description 2")
            )
        ),
        Store(
            R.drawable.store_image, "Loja 2", "Endereço 2", "00:00",
            listOf(
                Dish(R.drawable.dish_image, "Dish 3", "Description 3"),
                Dish(R.drawable.dish_image, "Dish 4", "Description 4")
            )
        ),
        Store(
            R.drawable.store_image, "Loja 3", "Endereço 3", "00:00",
            listOf(
                Dish(R.drawable.dish_image, "Dish 5", "Description 1"),
                Dish(R.drawable.dish_image, "Dish 6", "Description 2")
            )
        ),
        Store(
            R.drawable.store_image, "Loja 4", "Endereço 4", "00:00",
            listOf(
                Dish(R.drawable.dish_image, "Dish 7", "Description 7"),
                Dish(R.drawable.dish_image, "Dish 8", "Description 8"),
                Dish(R.drawable.dish_image, "Dish 8", "Description 8"),
                Dish(R.drawable.dish_image, "Dish 8", "Description 8"),
                Dish(R.drawable.dish_image, "Dish 8", "Description 8"),
                Dish(R.drawable.dish_image, "Dish 8", "Description 8"),
                Dish(R.drawable.dish_image, "Dish 8", "Description 8"),
                Dish(R.drawable.dish_image, "Dish 8", "Description 8"),
                Dish(R.drawable.dish_image, "Dish 8", "Description 8")
            )
        ),
        Store(
            R.drawable.store_image, "Loja 5", "Endereço 5", "00:00",
            listOf(
                Dish(R.drawable.dish_image, "Dish 1", "Description 1"),
                Dish(R.drawable.dish_image, "Dish 2", "Description 2")
            )
        )
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_store_list, container, false)

        recycler = view.findViewById(R.id.recyclerview)
        recycler.setHasFixedSize(true)
        recycler.layoutManager = LinearLayoutManager(view.context)
        recycler.adapter = StoreListAdapter(storeList, this)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as MainActivity).changeToolbar(getString(R.string.app_name), false)

        navController = Navigation.findNavController(view)
    }

    override fun onStoreClick(position: Int) {
        val bundle = Bundle()
        bundle.putParcelable("STORE", storeList[position])
        navController.navigate(R.id.storeMenuFragment, bundle)
    }
}