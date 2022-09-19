package com.example.shoestore.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.shoestore.R
import com.example.shoestore.databinding.FragmentAddShoeScreenBinding
import com.example.shoestore.model.ShoesModel
class AddShoeScreen : Fragment() {
    private lateinit var binding: FragmentAddShoeScreenBinding
    private lateinit var shoeVM : ShoeViewModel
    private lateinit var navController : NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        navController = findNavController()
        shoeVM  = ViewModelProvider(requireActivity()).get(ShoeViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_add_shoe_screen, container, false)
        //Add new Shoe
        binding.addnewshoes=ShoesModel()
        binding.addBtn.setOnClickListener {
                shoeVM.addShoes(binding.addnewshoes!!) //Add new Shoes to ViewModel the navigating to Shoe List Fragment
                navController.navigate(R.id.shoe_details_to_shoes_list)
            }

        return binding.root
    }
}