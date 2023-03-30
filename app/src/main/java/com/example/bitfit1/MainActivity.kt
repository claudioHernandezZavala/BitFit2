package com.example.bitfit1
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bitfit1.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private val foods = mutableListOf<displayFood>()
    private lateinit var foodRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val addToList = findViewById<Button>(R.id.mainbutton)


        foodRecyclerView = findViewById(R.id.food_list)

        // TODO: Set up ArticleAdapter with articles
        val foodAdapter1 = foodAdapter( foods)
        foodRecyclerView.adapter = foodAdapter1

        //TODO: Review how this adds itemDecoration
        foodRecyclerView.layoutManager = LinearLayoutManager(this).also {
            val dividerItemDecoration = DividerItemDecoration(this, it.orientation)
            foodRecyclerView.addItemDecoration(dividerItemDecoration)
        }

        lifecycleScope.launch {
            (application as FoodApplication).db.foodDao().getAll().collect { databaseList ->
                databaseList.map { entity ->
                    displayFood(
                        entity.foodName,
                        entity.calories.toString(),

                    )
                }.also { mappedList ->
                    foods.clear()
                    foods.addAll(mappedList)
                    foodAdapter1.notifyDataSetChanged()
                }
            }
        }

        addToList.setOnClickListener {
            val intent = Intent(this, addFood::class.java)
            startActivity(intent)
        }
    }
}