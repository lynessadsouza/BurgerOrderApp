package com.example.burgerorderapp.Model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "order_table")
data class OrderModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val total: Int,
    val breadBase: String
): Serializable {

}