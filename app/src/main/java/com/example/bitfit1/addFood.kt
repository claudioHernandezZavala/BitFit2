package com.example.bitfit1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class addFood : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_food)
        var btn = findViewById<Button>(R.id.addFoodButton)
        btn.setOnClickListener({
            var fName =  findViewById<EditText>(R.id.foodnameedit)
            var fCalorie =  findViewById<EditText>(R.id.foodcalorieedit)
            if(fName.text.isNotBlank()&&fCalorie.text.isNotBlank()){
                lifecycleScope.launch(Dispatchers.IO) {
                    //val memory = (application as LegDayApplication).db.legDayDao().getAll()
                    //(application as LegDayApplication).db.legDayDao().deleteAll()
                    (application as FoodApplication).db.foodDao().insertFood(
                        FoodEntity(
                            foodName = fName.text.toString(),
                            calories = Integer.parseInt(fCalorie.text.toString())

                        )
                    )
                }
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }



        })
    }
}