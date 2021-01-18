package com.example.digitalhousefoods

import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.material.appbar.MaterialToolbar

class DishDetailActivity : AppCompatActivity() {
    private val toolbar by lazy { findViewById<MaterialToolbar>(R.id.dish_detail_toolbar) }
    private val toolbarTitle by lazy { findViewById<TextView>(R.id.dish_detail_toolbar_title) }
    private val description by lazy { findViewById<TextView>(R.id.dish_description) }
    private val dish by lazy { intent.getParcelableExtra<Dish>(Constant.DISH) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dish_detail)

        setSupportActionBar(toolbar)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setBackgroundDrawable(
                ContextCompat.getDrawable(this@DishDetailActivity, dish!!.image)
            )
        }
        toolbarTitle.text = dish!!.name
        description.text = dish!!.description
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
}