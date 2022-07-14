package com.example.burgerorderapp.Database

import android.content.Context
import androidx.room.*
import com.example.burgerorderapp.Database.OrderDao
import com.example.burgerorderapp.Model.OrderModel


@Database(entities = [OrderModel::class], version = 1, exportSchema = false)
abstract class OrderDatabase : RoomDatabase() {
    abstract fun orderDao(): OrderDao

    companion object {
        @Volatile
        private var INSTANCE: OrderDatabase? = null

        fun getDatabase(context: Context): OrderDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    OrderDatabase::class.java,
                    "order_database"
                ).build()
                INSTANCE = instance
                return instance
            }

        }
    }
}


