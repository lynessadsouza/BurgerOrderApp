package com.example.burgerorderapp.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.burgerorderapp.Database.OrderDatabase
import com.example.burgerorderapp.Database.OrderDatabase.Companion.getDatabase
import com.example.burgerorderapp.Database.OrderRepository
import com.example.burgerorderapp.Model.OrderModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class OrderViewModel(application: Application) : AndroidViewModel(application) {
    val readAllData: LiveData<List<OrderModel>>
    private val repository: OrderRepository

    init {
        val orderDao = OrderDatabase.getDatabase(application).orderDao()
        repository = OrderRepository(orderDao)
        readAllData = repository.readAllData
    }


    fun addOrder(orderModel: OrderModel) {


        viewModelScope.launch(Dispatchers.IO) {
            repository.addOrder(orderModel)
        }

    }

    fun updateUser(orderModel: OrderModel) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateOrder(orderModel)
        }

    }





    fun readData(name: String) {
        viewModelScope.launch(Dispatchers.IO) {
        //    repository.readData(name)
        }
    }


}

//viewModelScope is attached to every instance of ViewModel.
// It runs out when the ViewModel is destroyed.

//Dispatchers help coroutines in deciding the thread on which the work has to be done