package com.example.hw5clone

data class YelpData (
    val total: Int,
    val businesses: List<restaurants>
)

data class restaurants (
    val name: String,
    val reviewCount: Int,
    val rating: Float,
    val distance: Double,
    val location: Location,
    val categories: List<foodcategories>,
    val price: String,
    val image_url: String
)

data class Location (
    val city: String,
    val country: String,
    val address1: String,
    val state: String,
    val zip_code: String
)

data class foodcategories (
    val title: String
)