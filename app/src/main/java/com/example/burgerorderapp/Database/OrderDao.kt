package com.example.burgerorderapp.Database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.burgerorderapp.Model.OrderModel

@Dao
interface OrderDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
     fun addOrder(orderModel: OrderModel)

    @Update
     fun updateOrder(orderModel: OrderModel)

    @Query("SELECT * FROM order_table ")
    fun readAllData():LiveData<List<OrderModel>>



}