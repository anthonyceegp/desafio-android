package com.example.digitalhousefoods

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class StoreMenuAdapter(
    private val dishList: List<Dish>,
    private val onDishClickListener: OnDishClickListener
) :
    RecyclerView.Adapter<StoreMenuViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoreMenuViewHolder {
        return StoreMenuViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.store_menu_item, parent, false)
        )
    }

    override fun getItemCount() = dishList.size

    override fun onBindViewHolder(holder: StoreMenuViewHolder, position: Int) {
        holder.bind(dishList[position], onDishClickListener)
    }
}

class StoreMenuViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val image = itemView.findViewById<ImageView>(R.id.image_menu)
    val title = itemView.findViewById<TextView>(R.id.title_menu)

    fun bind(dish: Dish, onDishClickListener: OnDishClickListener) {
        image.setImageResource(dish.image)
        image.contentDescription = dish.name
        title.text = dish.name

        itemView.setOnClickListener {
            onDishClickListener.onDishClick(adapterPosition)
        }
    }
}

interface OnDishClickListener {
    fun onDishClick(position: Int)
}