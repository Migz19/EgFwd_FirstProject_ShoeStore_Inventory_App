package com.example.shoestore.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoestore.model.ShoesModel

class ShoeViewModel : ViewModel() {
    /*Initialized data are stored in private mutable live data
        and accessing data through get method for live data list in order to realize
        encapsulation principle
     */
    private val description = "From high-top to low-top. Live the legend of the Air Force 1, modernized for ultimate street style."
    private var mutableLiveData = MutableLiveData(arrayListOf(
        ShoesModel("Air Jordan 1","Sports",description,260.99),ShoesModel("Air Max 270","Nike",description,200.0),
        ShoesModel("Air Force 7","Puma",description,200.00),ShoesModel("Dunk Low","Puma",description,300.99),
        ShoesModel("Air Max 97","Adidas",description,300.99),ShoesModel("Air Jordan Retro","Nike",description,350.99),
        ShoesModel("Vapor Max","Adidas",description,400.99),ShoesModel("Air Max Bolt","Nike",description,450.99)
    )
    )


    fun addShoes (shoes :ShoesModel) {
        mutableLiveData.value?.add(shoes)
    }
    val liveData : LiveData<ArrayList<ShoesModel>>
    get() = mutableLiveData

}