package com.example.bitfit1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

const val REQUEST_CODE = 0


class MainActivity : AppCompatActivity() {
    lateinit var foods: MutableList<displayFood>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var mainAddButton =  findViewById<Button>(R.id.mainbutton)
        mainAddButton.setOnClickListener({
            val intent = Intent(this, addFood::class.java)

            startActivityForResult(intent, REQUEST_CODE)
        })
        var foodrv =  findViewById<RecyclerView>(R.id.food_list)

//        lifecycleScope.launch(IO) { {
//            (application as FoodApplication).db.foodDao().deleteAll()
//            (application as FoodApplication).db.foodDao().insertFood(displayFood("chocolate","500"))
//        }
        val foods = mutableListOf<displayFood>()
//       val  foods =(application as FoodApplication).db.foodDao().getAll()
        //create instance of adapter
        val adapter = FoodAdapter(foods)
         fun onActivityResult(
            requestCode: Int, resultCode: Int,
            data: Intent?
        ) {
            super.onActivityResult(requestCode, resultCode, data)
            if (requestCode == REQUEST_CODE) {
                if (resultCode == RESULT_OK) {
                    if (data != null) {
                        foods.add(displayFood(data.getStringExtra("foodName"),data.getStringExtra("calories")))
                        adapter.notifyDataSetChanged()
                    }

                }
            }
        }

        foodrv.adapter =  adapter

        foodrv.layoutManager = LinearLayoutManager(this)






    }

}

