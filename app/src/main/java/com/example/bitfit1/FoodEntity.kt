package com.example.bitfit1

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "food")
data class FoodEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    @ColumnInfo(name = "foodName") val foodName: String?,
    @ColumnInfo(name = "calories") val calories: Int?,

)