package com.example.bitfit1

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface FoodDao{
    @Query("SELECT * FROM food")
    fun getAll(): Flow<List<FoodEntity>>
    @Insert
    fun insertAll(foods: List<FoodEntity>)

    @Query("DELETE FROM food")
    fun deleteAll()

    @Insert
    fun insertFood(food1:FoodEntity)

}