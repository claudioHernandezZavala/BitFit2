package com.example.bitfit1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class foodAdapter(private val items: List<displayFood>) : RecyclerView.Adapter<foodAdapter.ViewHolder>(){
    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        // TODO: Create member variables for any view that will be set
        // as you render a row.
        val foodName: TextView
        val calorie: TextView


        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each sub-view
        init {
            // TODO: Store each of the layout's views into
            // the public final member variables created above
            foodName=itemView.findViewById(R.id.foodNameView)
            calorie = itemView.findViewById(R.id.caloriesView)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val contactView = inflater.inflate(R.layout.food_layout, parent, false)
        // Return a new holder instance
        return ViewHolder(contactView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Get the data model based on position
        val item = items.get(position)
        // Set item views based on views and data model
        holder.foodName.text=item.foodName
        holder.calorie.text = item.calories


    }

    override fun getItemCount(): Int {
        return items.size
    }
}