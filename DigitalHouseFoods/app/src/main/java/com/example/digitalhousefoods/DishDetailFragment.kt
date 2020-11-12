package com.example.digitalhousefoods

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class DishDetailFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_dish_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dishName = view.findViewById<TextView>(R.id.dish_name)
        val dishDescription = view.findViewById<TextView>(R.id.dish_description)
        val dish = arguments?.getParcelable<Dish>("DISH")

        (activity as MainActivity).changeToolbar(dish!!.name, true)

        dishName.text = dish.name
        dishDescription.text = dish.description
    }
}