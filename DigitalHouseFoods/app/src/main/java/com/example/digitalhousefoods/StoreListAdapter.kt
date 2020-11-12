package com.example.digitalhousefoods

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class StoreListAdapter(
    private val storeList: List<Store>,
    private val onStoreClickListener: OnStoreClickListener
) :
    RecyclerView.Adapter<StoreViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoreViewHolder {
        return StoreViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.store_list_item, parent, false)
        )
    }

    override fun getItemCount() = storeList.size

    override fun onBindViewHolder(holder: StoreViewHolder, position: Int) {
        holder.bind(storeList[position], onStoreClickListener)
    }
}

class StoreViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val image = itemView.findViewById<ImageView>(R.id.image_card)
    val title = itemView.findViewById<TextView>(R.id.title_card)
    val address = itemView.findViewById<TextView>(R.id.address_card)
    val closingTime = itemView.findViewById<TextView>(R.id.closing_time)

    fun bind(store: Store, onStoreClickListener: OnStoreClickListener) {
        image.setImageResource(store.image)
        title.text = store.name
        address.text = store.address
        closingTime.text = "Fecha às " + store.closingTime

        itemView.setOnClickListener {
            onStoreClickListener.onStoreClick(adapterPosition)
        }
    }
}

interface OnStoreClickListener {
    fun onStoreClick(position: Int)
}