package com.example.shoestore.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.shoestore.R
import com.example.shoestore.databinding.FragmentInstructionsScreenBinding
import com.example.shoestore.databinding.FragmentWelcomeScreenBinding

class InstructionsScreen : Fragment() {
    private lateinit var navController: NavController
    private lateinit var binding: FragmentInstructionsScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        navController= findNavController()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_instructions_screen, container, false)
        binding.button2.setOnClickListener {
            navController.navigate(R.id.action_instructionsScreen2_to_shoeListFragment)
            //Clicking on get started button will navigate to Instructions screen
        }
        return binding.root
    }

}