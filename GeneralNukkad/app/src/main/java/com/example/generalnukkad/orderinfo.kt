package com.example.generalnukkad

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.example.generalnukkad.MainActivity.Companion.KEY

class orderinfo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_orderinfo)

        val Orderlist = findViewById<TextView>(R.id.orders)
        val btnfinish = findViewById<TextView>(R.id.btnfinish)
        val imprtedordersinfo = intent.getStringExtra(MainActivity.KEY)
        Orderlist.text= imprtedordersinfo.toString()

        btnfinish.setOnClickListener{
            Toast.makeText(applicationContext, "Order Placed :)", Toast.LENGTH_SHORT).show()

        }



    }
}