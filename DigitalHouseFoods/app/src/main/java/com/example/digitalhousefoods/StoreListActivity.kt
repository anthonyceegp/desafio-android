package com.example.digitalhousefoods

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.MaterialToolbar

class StoreListActivity : AppCompatActivity(), OnStoreClickListener {
    private val toolbar by lazy { findViewById<MaterialToolbar>(R.id.store_list_toolbar) }
    private val recycler by lazy { findViewById<RecyclerView>(R.id.store_list_recycler) }
    private val storeList = getStoreList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_store_list)

        setSupportActionBar(toolbar)

        recycler.setHasFixedSize(true)
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = StoreListAdapter(storeList, this)
    }

    override fun onStoreClick(position: Int) {
        intent = Intent(this, StoreMenuActivity::class.java)
        intent.putExtra(Constant.STORE, storeList[position])

        startActivity(intent)
    }

    private fun getStoreList(): List<Store> {
        return listOf(
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
    }
}