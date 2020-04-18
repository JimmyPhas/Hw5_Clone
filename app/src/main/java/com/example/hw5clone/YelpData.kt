package com.example.hw5clone

import com.google.gson.annotations.SerializedName

data class YelpData (
    val results: List<Yelp>
)

data class Yelp (
    val name: String,
    val review_count: String,
    val rating: Float,
    val distance: String,
    val location: Location,
    val searchterm: String,
//    val categories: CategoryData,
    val price: String,
    @SerializedName("picture") val image_url: Picture
)

data class Location (
    val city: String,
    val country: String,
    val address1: String,
    val address2: String,
    val address3: String,
    val state: String,
    val zip_code: String
)

data class CategoryData (
    val categorylist: List<Categories>
)

data class Categories (
    val alias: String,
    val title: String
)

data class Picture (
    val medium: String
)