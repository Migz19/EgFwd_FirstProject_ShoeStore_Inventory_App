package com.example.shoestore.ui

import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.shoestore.R
import com.example.shoestore.databinding.ActivityMainBinding
import com.example.shoestore.databinding.FragmentLoginScreenBinding

class LoginScreen : Fragment() {
    private lateinit var binding : FragmentLoginScreenBinding
    private lateinit var navController : NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        navController = findNavController()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_login_screen, container, false)
        binding.loginBtn1.setOnClickListener {
            if (checkCredentials())
                navController.navigate(R.id.action_loginScreen_to_welcomeScreen)
        }
        binding.loginBtn2.setOnClickListener {
            if (checkCredentials())
                navController.navigate(R.id.action_loginScreen_to_welcomeScreen)
        }
        return binding.root
    }


    private fun checkCredentials ():Boolean{ //check if email and password input != null
        if (binding.emailTxt.text.isEmpty()||binding.passwordTxt.text.isEmpty()){
            Toast.makeText(requireContext(),"Please fill required fields",Toast.LENGTH_SHORT).show()
            return false
        }
        else
            return true
    }

}