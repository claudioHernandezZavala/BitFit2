package com.example.bitfit1

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface FoodDao{
    @Query("SELECT * FROM food")
    fun getAll(): MutableList<displayFood>
    @Insert
    fun insertAll(articles: List<displayFood>)

    @Query("DELETE FROM food")
    fun deleteAll()

    @Insert
    fun insertFood(food1: displayFood)

}