package com.sheldon.sheldoncafe

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.sheldon.sheldoncafe.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var textMessage: TextView
    lateinit var binding: ActivityMainBinding
    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_order_new_page -> {
                textMessage.setText(R.string.title_order_new_page)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_order_list_page -> {
                textMessage.setText(R.string.title_order_list_page)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        textMessage = binding.message
        binding.navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)

    }
}
