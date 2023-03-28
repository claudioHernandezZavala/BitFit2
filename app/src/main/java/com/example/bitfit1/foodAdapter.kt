package com.example.bitfit1

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class FoodAdapter(private val foods:MutableList<displayFood>) : RecyclerView.Adapter<FoodAdapter.ViewHolder>() {

    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // Your holder should contain and initialize a member variable
        // for any view that will be set as you render a row
        val foodName = itemView.findViewById<TextView>(R.id.foodNameView)
        val calories = itemView.findViewById<TextView>(R.id.caloriesView)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val wishItemView = inflater.inflate(R.layout.food_layout, parent, false)
        // Return a new holder instance
        return ViewHolder(wishItemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Get the data model based on position
        val food = foods.get(position)
        // Set item views based on views and data model
        holder.foodName.text = food.foodName
        holder.calories.text = food.calories

//        holder.itemUrl.setOnClickListener({
//            try {
//                val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(wish.url))
//                ContextCompat.startActivity(it.context, browserIntent, null)
//            } catch (e: ActivityNotFoundException) {
//                Toast.makeText(it.context, "Invalid URL ", Toast.LENGTH_LONG).show()
//            }
//        })
//        holder.card.setClickable(true);
//        holder.card.setFocusable(false);
//        holder.card.setOnLongClickListener{
//            wishItems.removeAt(position)
//            this.notifyDataSetChanged()
//            true
//
//        }



    }

    override fun getItemCount(): Int {
        return foods.size;
    }
}