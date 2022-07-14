package com.example.burgerorderapp

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.example.burgerorderapp.Model.OrderModel
import com.example.burgerorderapp.ViewModel.OrderViewModel

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var price = 239
    var quantity = 0
    var selectedBread = "Multigrain"
    var total = 0
    private lateinit var orderViewModel: OrderViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        orderViewModel = ViewModelProvider(this).get(OrderViewModel::class.java)

        order.setOnClickListener {
            if (total > 0) {
                Log.d("Final Order", "$quantity, $total, $selectedBread")
                orderViewModel.addOrder(OrderModel(1, total, selectedBread))
                Log.d("Item addes", "Item Added")
                //showAlert()
                val builder = AlertDialog.Builder(this, R.style.CustomAlertDialog).create()
                val view = layoutInflater.inflate(R.layout.customview_layout, null)
                val button = view.findViewById<Button>(R.id.dialogDismiss_button)

                builder.setView(view)

                builder.getWindow()?.getAttributes()?.windowAnimations = R.style.DialogAnimation;
                button.setOnClickListener {
                    builder.dismiss()
                }
                builder.setCanceledOnTouchOutside(false)

                builder.show()
            } else {
                Toast.makeText(applicationContext, "Please Add Items", Toast.LENGTH_LONG).show()
            }


        }
        Log.d("Price", "$price")
        plus.setOnClickListener {
            quantity++
            unit.text = quantity.toString()
            total = quantity * price
            order.text = "ADD (${quantity * price})"

        }
        minus.setOnClickListener {
            Log.d("Tag", "$quantity")
            if (quantity >= 1) {
                quantity--
                unit.text = quantity.toString()
                total = quantity * price
                order.text = "ADD (${quantity * price})"
            }
        }

        sizeSelection2.setOnClickListener {
            size1.apply {
                setTypeface(typeface, Typeface.NORMAL)
            }
            size1.setTypeface(null, Typeface.NORMAL)
            size1Price.setTypeface(null, Typeface.NORMAL)
            size2.setTypeface(null, Typeface.BOLD)
            size2.setTypeface(null, Typeface.BOLD)
            size2Price.setTypeface(null, Typeface.BOLD)
            price = 409
            Log.d("Price sel2", "$price")
            sizeSelection1.setImageDrawable(
                ContextCompat.getDrawable(
                    applicationContext,
                    R.drawable.unselectedicon
                )
            )
            sizeSelection2.setImageDrawable(
                ContextCompat.getDrawable(
                    applicationContext,
                    R.drawable.selectedicon
                )
            )
            size2.apply {
                setTypeface(typeface, Typeface.NORMAL)
            }

            //for price changes
            total = quantity * price
            order.text = "ADD (${quantity * price})"

        }

        sizeSelection1.setOnClickListener {
            size1.apply { setTypeface(typeface, Typeface.BOLD) }
            size1.setTypeface(null, Typeface.BOLD)
            size1Price.setTypeface(null, Typeface.BOLD)
            size2.setTypeface(null, Typeface.NORMAL)
            size2.setTypeface(null, Typeface.NORMAL)
            size2Price.setTypeface(null, Typeface.NORMAL)



            size2.apply {
                setTypeface(typeface, Typeface.NORMAL)
            }

            price = 239
            Log.d("Price sel1", "$price")
            sizeSelection2.setImageDrawable(
                ContextCompat.getDrawable(
                    applicationContext,
                    R.drawable.unselectedicon
                )
            )
            sizeSelection1.setImageDrawable(
                ContextCompat.getDrawable(
                    applicationContext,
                    R.drawable.selectedicon
                )
            )
            size1.apply {
                setTypeface(typeface, Typeface.NORMAL)
            }
            total = quantity * price
            order.text = "ADD (${quantity * price})"
        }

        Log.d("Price", "$price")


        choiceBreadSelection1.setOnClickListener {
            selectedBread = "Multigrain"
            choiceBread1.setTypeface(null, Typeface.BOLD)
            choiceBread2.setTypeface(null, Typeface.NORMAL)
            choiceBread3.setTypeface(null, Typeface.NORMAL)
            choiceBread4.setTypeface(null, Typeface.NORMAL)
            choiceBreadSelection1.setImageDrawable(
                ContextCompat.getDrawable(
                    applicationContext,
                    R.drawable.selectedicon
                )
            )
            choiceBreadSelection2.setImageDrawable(
                ContextCompat.getDrawable(
                    applicationContext,
                    R.drawable.unselectedicon
                )
            )
            choiceBreadSelection3.setImageDrawable(
                ContextCompat.getDrawable(
                    applicationContext,
                    R.drawable.unselectedicon
                )
            )
            choiceBreadSelection4.setImageDrawable(
                ContextCompat.getDrawable(
                    applicationContext,
                    R.drawable.unselectedicon
                )
            )
        }
        choiceBreadSelection2.setOnClickListener {
            selectedBread = "Multigrain Honey Oats Bread"
            choiceBread1.setTypeface(null, Typeface.NORMAL)
            choiceBread2.setTypeface(null, Typeface.BOLD)
            choiceBread3.setTypeface(null, Typeface.NORMAL)
            choiceBread4.setTypeface(null, Typeface.NORMAL)

            choiceBreadSelection2.setImageDrawable(
                ContextCompat.getDrawable(
                    applicationContext,
                    R.drawable.selectedicon
                )
            )
            choiceBreadSelection1.setImageDrawable(
                ContextCompat.getDrawable(
                    applicationContext,
                    R.drawable.unselectedicon
                )
            )
            choiceBreadSelection3.setImageDrawable(
                ContextCompat.getDrawable(
                    applicationContext,
                    R.drawable.unselectedicon
                )
            )
            choiceBreadSelection4.setImageDrawable(
                ContextCompat.getDrawable(
                    applicationContext,
                    R.drawable.unselectedicon
                )
            )

        }
        choiceBreadSelection3.setOnClickListener {
            selectedBread = "White Italian Bread"
            choiceBread3.setTypeface(null, Typeface.BOLD)
            choiceBread2.setTypeface(null, Typeface.NORMAL)
            choiceBread1.setTypeface(null, Typeface.NORMAL)
            choiceBread4.setTypeface(null, Typeface.NORMAL)

            choiceBreadSelection3.setImageDrawable(
                ContextCompat.getDrawable(
                    applicationContext,
                    R.drawable.selectedicon
                )
            )
            choiceBreadSelection1.setImageDrawable(
                ContextCompat.getDrawable(
                    applicationContext,
                    R.drawable.unselectedicon
                )
            )
            choiceBreadSelection2.setImageDrawable(
                ContextCompat.getDrawable(
                    applicationContext,
                    R.drawable.unselectedicon
                )
            )
            choiceBreadSelection4.setImageDrawable(
                ContextCompat.getDrawable(
                    applicationContext,
                    R.drawable.unselectedicon
                )
            )

        }
        choiceBreadSelection4.setOnClickListener {
            selectedBread = "Roasted Garlic"
            choiceBread4.setTypeface(null, Typeface.BOLD)
            choiceBread2.setTypeface(null, Typeface.NORMAL)
            choiceBread3.setTypeface(null, Typeface.NORMAL)
            choiceBread1.setTypeface(null, Typeface.NORMAL)

            choiceBreadSelection2.setImageDrawable(
                ContextCompat.getDrawable(
                    applicationContext,
                    R.drawable.unselectedicon
                )
            )
            choiceBreadSelection3.setImageDrawable(
                ContextCompat.getDrawable(
                    applicationContext,
                    R.drawable.unselectedicon
                )
            )
            choiceBreadSelection1.setImageDrawable(
                ContextCompat.getDrawable(
                    applicationContext,
                    R.drawable.unselectedicon
                )
            )
            choiceBreadSelection4.setImageDrawable(
                ContextCompat.getDrawable(
                    applicationContext,
                    R.drawable.selectedicon
                )
            )
        }


    }


}