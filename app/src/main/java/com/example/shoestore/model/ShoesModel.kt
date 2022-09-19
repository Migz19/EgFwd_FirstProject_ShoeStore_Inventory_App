package com.example.shoestore.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ShoesModel(
    var name :String = "",
    var brand : String= "",
    var description: String="",
    var size: Double=0.0,
    val images: List<String> = mutableListOf()) : Parcelable


