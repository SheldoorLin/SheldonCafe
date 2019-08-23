package com.sheldon.sheldoncafe

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.sheldon.sheldoncafe.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        val navController = this.findNavController(R.id.navHostFragment)
        when (item.itemId) {
            R.id.navigation_order_new_page -> {
                navController.navigate(R.id.action_global_orderNewFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_order_list_page -> {
                navController.navigate(R.id.action_global_orderListFragment)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
    }
}
