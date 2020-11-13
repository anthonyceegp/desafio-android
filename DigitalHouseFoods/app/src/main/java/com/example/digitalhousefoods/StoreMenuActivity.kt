package com.example.digitalhousefoods

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.MaterialToolbar

class StoreMenuActivity : AppCompatActivity(), OnDishClickListener {
    private val toolbar by lazy { findViewById<MaterialToolbar>(R.id.store_menu_toolbar) }
    private val toolbarTitle by lazy { findViewById<TextView>(R.id.store_menu_toolbar_title) }
    private val recycler by lazy { findViewById<RecyclerView>(R.id.store_menu_recycler) }
    private val store by lazy { intent.getParcelableExtra<Store>("STORE") }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_store_menu)

        setSupportActionBar(toolbar)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setBackgroundDrawable(
                ContextCompat.getDrawable(this@StoreMenuActivity, store!!.image)
            )
        }
        toolbarTitle.text = store!!.name

        recycler.setHasFixedSize(true)
        recycler.layoutManager = GridLayoutManager(this, 2)
        recycler.adapter = StoreMenuAdapter(store!!.dishList, this)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onDishClick(position: Int) {
        intent = Intent(this, DishDetailActivity::class.java)
        intent.putExtra("DISH", store!!.dishList[position])

        startActivity(intent)
    }
}