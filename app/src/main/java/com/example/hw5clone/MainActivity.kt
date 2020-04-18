package com.example.hw5clone

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.Call
import retrofit2.Response
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"
    private val BASE_URL = "https://api.yelp.com/v3/"
    private val API_KEY = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory((GsonConverterFactory.create())).build()
        val yelpSearchService = retrofit.create(YelpSearchService::class.java)
        yelpSearchService.getFoodSearch("Bearer $API_KEY", "Pizza").enqueue(object : Callback<Any> {
            override fun onFailure(call: Call<Any>, t: Throwable) {
                Log.i(TAG, "onFailure $t")
            }

            override fun onResponse(call: Call<Any>, response: Response<Any>) {
                Log.i(TAG, "onResponse $response")
            }
        })

    }

    fun searchYelp(view:View) {

//        val yelpList = ArrayList<Yelp>()
//        val adapter = YelpAdapter(yelpList)
//        searchList.adapter = adapter
//        searchList.layoutManager = LinearLayoutManager(this)
//
//        val retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
//
//        val yelpSearchAPI = retrofit.create(YelpSearchService::class.java)
//
//        if ( !foodSearch.text.toString().isNullOrBlank() && locationSearch.text.toString().isNullOrBlank() ) {
//            val food = foodSearch.text.toString()
//            yelpSearchAPI.getFoodSearch("Bearer $API_KEY", food).enqueue(object : Callback<YelpData> {
//                override fun onFailure(call: Call<YelpData>, t: Throwable) {
//                    Log.d(TAG, "onFailure : $t")
//                }
//
//                override fun onResponse(call: Call<YelpData>, response: Response<YelpData>) {
//                    Log.d(TAG, "onResponse: $response")
//
//                    val body = response.body()
//
//                    if (body == null){
//                        Log.w(TAG, "Valid response was not received")
//                        return
//                    }
//
//                    Log.d(TAG, ": ${body.results.get(0).name}")
//                    Log.d(TAG, ": ${body.results.get(0).review_count}")
//                    Log.d(TAG, ": ${body.results.get(0).rating}")
//                    Log.d(TAG, ": ${body.results.get(0).distance}")
//                    Log.d(TAG, ": ${body.results.get(0).location.address1}")
//                    Log.d(TAG, ": ${body.results.get(0).searchterm}")
////                    Log.d(TAG, ": ${body.results.get(0).categories}")
//                    Log.d(TAG, ": ${body.results.get(0).price}")
//                    Log.d(TAG, ": ${body.results.get(0).image_url.medium}")
//
//                    yelpList.addAll(body.results)
//                    adapter.notifyDataSetChanged()
//                }
//            })
//        }
//        else if ( foodSearch.text.toString().isNullOrBlank() && !locationSearch.text.toString().isNullOrBlank() ) {
//
//        }
//        else if ( !foodSearch.text.toString().isNullOrBlank() && !locationSearch.text.toString().isNullOrBlank() ) {
//
//        }
//        else {
//            var toastMessage = Toast.makeText(this, "Please enter a Food Item or Location to search", Toast.LENGTH_LONG)
//            toastMessage.setGravity(Gravity.CENTER, 0, 0)
//            toastMessage.show()
//        }

        val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

}
