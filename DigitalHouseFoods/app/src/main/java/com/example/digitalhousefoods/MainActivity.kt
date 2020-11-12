package com.example.digitalhousefoods

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity() {
    private val toolbar by lazy { findViewById<Toolbar>(R.id.default_appbar) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)
    }

    fun changeToolbar(title: String, enableHomeButton: Boolean) {
        supportActionBar!!.setDisplayHomeAsUpEnabled(enableHomeButton)
        supportActionBar!!.title = title
    }
}