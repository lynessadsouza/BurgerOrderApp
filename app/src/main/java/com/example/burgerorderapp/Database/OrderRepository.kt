package com.example.burgerorderapp.Database

import androidx.lifecycle.LiveData
import com.example.burgerorderapp.Database.OrderDao
import com.example.burgerorderapp.Model.OrderModel


class OrderRepository(private val orderDao: OrderDao) {
    val readAllData: LiveData<List<OrderModel>> = orderDao.readAllData()

     fun addOrder(orderModel: OrderModel) {
        orderDao.addOrder(orderModel)
    }

     fun updateOrder(orderModel: OrderModel)
    {
        orderDao.updateOrder(orderModel)
    }




}