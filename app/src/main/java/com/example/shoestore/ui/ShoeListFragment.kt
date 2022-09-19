package com.example.shoestore.ui

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.shoestore.R
import com.example.shoestore.databinding.FragmentShoeListBinding
import com.example.shoestore.databinding.ListLayoutBinding
import com.example.shoestore.model.ShoesModel

class ShoeListFragment : Fragment() {
    private lateinit var fragmentBinding: FragmentShoeListBinding
    private lateinit var listBinding: ListLayoutBinding
    private lateinit var shoesVModel : ShoeViewModel
    private lateinit var navController : NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         navController = findNavController()
        shoesVModel = ViewModelProvider(requireActivity()).get(ShoeViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_shoe_list, container, false)
        fragmentBinding.layoutList.removeAllViews()
        //removing all views each time we start the fragment to refresh the layout

        //Observe Live data changes and send the updated data to inflation function
        shoesVModel.liveData.observe(viewLifecycleOwner) { shoesList ->
            inflateItems(shoesList)
        }
        fragmentBinding.floatingActionButton.setOnClickListener {
            navController.navigate(R.id.shoeList_to_shoe_details )
            //Navigate to Shoes details screen
        }
        fragmentBinding.backBtn.setOnClickListener {
            navController.navigate(R.id.action_shoeListFragment_to_loginScreen)
            //pop up to login screen
        }

        return fragmentBinding.root
    }

    //Inflating items from viewModel livedata List by 2-way Binding
    private fun inflateItems (shoesList : ArrayList<ShoesModel>){
        for (shoes in shoesList ){
            listBinding = DataBindingUtil.inflate(layoutInflater,R.layout.list_layout,null,false)
            listBinding.shoesModel = shoes
            fragmentBinding.layoutList.addView(listBinding.root)
        }
    }


}