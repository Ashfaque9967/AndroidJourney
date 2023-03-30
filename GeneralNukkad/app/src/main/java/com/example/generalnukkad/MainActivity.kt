 package com.example.generalnukkad

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

 class MainActivity : AppCompatActivity() {

     companion object{

        const val KEY = "com.example.generalnukkad.MAinActivity.key"

     }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnorder = findViewById<Button>(R.id.btnorder)
        val order1 = findViewById<EditText>(R.id.eT1)
        val order2 = findViewById<EditText>(R.id.eT2)
        val order3 = findViewById<EditText>(R.id.eT3)
        val order4 = findViewById<EditText>(R.id.eT4)

        btnorder.setOnClickListener {

            val orders = order1.text.toString() + "\n" +order2.text.toString() + "\n" +
            order3.text.toString() + "\n" + order4.text.toString()


            intent = Intent(this, orderinfo::class.java)
            intent.putExtra(KEY, orders)
            startActivity(intent)

        }

    }
}