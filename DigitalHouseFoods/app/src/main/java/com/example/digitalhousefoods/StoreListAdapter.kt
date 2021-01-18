package com.example.digitalhousefoods

import android.content.Context
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
            LayoutInflater.from(parent.context)
                .inflate(R.layout.store_list_item, parent, false),
            parent.context
        )
    }

    override fun getItemCount() = storeList.size

    override fun onBindViewHolder(holder: StoreViewHolder, position: Int) {
        holder.bind(storeList[position], onStoreClickListener)
    }
}

class StoreViewHolder(
    itemView: View,
    private val context: Context
) : RecyclerView.ViewHolder(itemView) {

    private val image: ImageView = itemView.findViewById(R.id.image_card)
    private val title: TextView = itemView.findViewById(R.id.title_card)
    private val address: TextView = itemView.findViewById(R.id.address_card)
    private val closingTime: TextView = itemView.findViewById(R.id.closing_time)

    fun bind(store: Store, onStoreClickListener: OnStoreClickListener) {
        image.setImageResource(store.image)
        image.contentDescription = store.name
        title.text = store.name
        address.text = store.address
        closingTime.text = context.getString(R.string.fecha_as, store.closingTime)

        itemView.setOnClickListener {
            onStoreClickListener.onStoreClick(adapterPosition)
        }
    }
}

interface OnStoreClickListener {
    fun onStoreClick(position: Int)
}