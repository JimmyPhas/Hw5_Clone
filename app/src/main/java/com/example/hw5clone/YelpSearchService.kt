package com.example.hw5clone

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface YelpSearchService {
    @GET("businesses/search")
    fun getFoodSearch (
        @Header("Authorization") authHeader: String,
        @Query("categories") categories: String,
        @Query("location") location: String): Call<YelpData> // YelpData Any

    @GET("businesses/search")
    fun getLocationSearch (
        @Header("Authorization") authHeader: String,
        @Query("location") location: String) : Call<YelpData>

    @GET("businesses/search")
    fun getFoodLocation (
        @Header("Authorization") authHeader: String,
        @Query("categories") categories: String,
        @Query("location") location: String) : Call<YelpData>
}