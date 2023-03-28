package com.example.bitfit1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class addFood : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_food)
        var btn = findViewById<Button>(R.id.addFoodButton)
        btn.setOnClickListener({
            var fName =  findViewById<EditText>(R.id.foodnameedit)
            var fCalorie =  findViewById<EditText>(R.id.foodcalorieedit)
            if(fName.text.isNotBlank()&&fCalorie.text.isNotBlank()){
                val intent =  Intent(this,MainActivity::class.java);
//                MainActivity().foods.add(displayFood(fName.text.toString(),fCalorie.text.toString()))
                intent.putExtra("foodName", fName.text.toString());
                intent.putExtra("calories", fCalorie.text.toString());
                setResult(RESULT_OK, intent);

                finish();
            }


        })
    }
}