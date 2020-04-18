package com.example.hw5clone

import com.google.gson.annotations.SerializedName

data class YelpData (
    @SerializedName("total") val total: Int,
    @SerializedName("businesses") val results: List<restaurants>
)

data class restaurants (
    @SerializedName("name") val name: String,
    @SerializedName("review_count") val reviewCount: Int,
    val rating: Float,
    val distance: Double,
    val location: Location,
    val searchterm: String,
    val categories: List<foodcategories>,
    val price: String,
    @SerializedName("image_url") val imageUrl: String
)

data class Location (
    val city: String,
    val country: String,
    @SerializedName("address1") val address: String,
    val state: String,
    @SerializedName("zip_code") val zipCode: String
)

data class foodcategories (
    val title: String
)

data class Picture (
    val medium: String
)