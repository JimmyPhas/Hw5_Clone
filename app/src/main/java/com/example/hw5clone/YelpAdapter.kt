package com.example.hw5clone

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.row_item.view.*
import com.squareup.picasso.Picasso

class YelpAdapter (private val businesses: ArrayList<restaurants>) : RecyclerView.Adapter<YelpAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = businesses[position]
        holder.name.text = currentItem.name
        holder.review_count.text = currentItem.reviewCount.toString()
        holder.rating.rating = currentItem.rating
        holder.location.text = currentItem.location.address
        holder.categories.text = currentItem.categories[0].title
        holder.price.text = currentItem.price

        Picasso.get().load(currentItem.imageUrl).into(holder.profileImage)

        val convert = currentItem.distance * 0.000621371
        val miles = "%.2f".format(convert) + " mi"
        holder.distance.text = miles

    }

    override fun getItemCount(): Int {
        return businesses.size
    }

    inner class MyViewHolder (itemView: View): RecyclerView.ViewHolder (itemView) {
        val name = itemView.tv_name
        val review_count = itemView.tv_review_count
        val rating = itemView.tv_rating
        val distance = itemView.tv_distance
        val location = itemView.tv_address
        val price = itemView.tv_price
        val profileImage = itemView.image_profile
        val categories = itemView.tv_categories
    }
}