package com.example.shoestore.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.shoestore.R
import com.example.shoestore.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding :ActivityMainBinding
    private lateinit var navController: NavController
    private lateinit var navHostFragment: NavHostFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Start the navHost Fragment
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
         navHostFragment = supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        navController = navHostFragment.navController
    }

}