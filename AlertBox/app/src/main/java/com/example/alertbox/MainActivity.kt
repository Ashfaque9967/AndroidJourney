package com.example.alertbox

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val exit = findViewById<Button>(R.id.btnexit)
        val select = findViewById<Button>(R.id.btnselect)
        val me = findViewById<Button>(R.id.btnme)

        exit.setOnClickListener {

            val builder = AlertDialog.Builder(this)
            builder.setTitle("EXIT")
            builder.setMessage("Exiting the application.")
            builder.setIcon(R.drawable.baseline_exit_to_app_24)
            builder.setPositiveButton("Exit", DialogInterface.OnClickListener { dialogInterface, i ->
                finish()
            })
            builder.setNegativeButton("Cancel", DialogInterface.OnClickListener { dialogInterface, i ->

            })
            builder.show()
        }

        select.setOnClickListener {

            val option = arrayOf("Veg", "Non-Veg")
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Who are you?")
            builder.setIcon(R.drawable.baseline_question_mark_24)
            builder.setSingleChoiceItems(option, 0, DialogInterface.OnClickListener { dialogInterface, i ->
                Toast.makeText(this, "${option[i]}", Toast.LENGTH_SHORT).show()
            })
            builder.setPositiveButton("Done", DialogInterface.OnClickListener { dialogInterface, i ->
            })
            builder.setNegativeButton("Cancel", DialogInterface.OnClickListener { dialogInterface, i ->
            })
            builder.show()
        }

        me.setOnClickListener {

            val option = arrayOf("chicken", "Mutton", "Beaf", "Pork")
            val builder = AlertDialog.Builder(this)
            builder.setTitle("What you like?")
            builder.setIcon(R.drawable.baseline_question_mark_24)
            builder.setMultiChoiceItems(option, null, DialogInterface.OnMultiChoiceClickListener { dialogInterface, i, b ->
                Toast.makeText(this, "${option[i]}", Toast.LENGTH_SHORT).show()

            })
            builder.setPositiveButton("Done", DialogInterface.OnClickListener { dialogInterface, i ->
            })
            builder.setNegativeButton("Cancel", DialogInterface.OnClickListener { dialogInterface, i ->
            })
            builder.show()
        }
    }
}