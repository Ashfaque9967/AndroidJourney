package com.example.assignmentalertbox

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

        supportActionBar?.hide()

        val Q1 = findViewById<Button>(R.id.Q1)
        val Q2 = findViewById<Button>(R.id.Q2)
        val Q3 = findViewById<Button>(R.id.Q3)
        val Exit = findViewById<Button>(R.id.Exit)

        Q1.setOnClickListener {
            val option = arrayOf("A friut", "A red fruit", "Devil's fruit")
            val box = AlertDialog.Builder(this)
            box.setTitle("Apple is ?")
            box.setIcon(R.drawable.baseline_circle_24)
            box.setMultiChoiceItems(option, null, DialogInterface.OnMultiChoiceClickListener { dialogInterface, i, b ->

                Toast.makeText(this, "${option[i]}", Toast.LENGTH_SHORT).show()

            })
            box.setPositiveButton("Submit", DialogInterface.OnClickListener { dialogInterface, i ->  })

            box.setNegativeButton("Cancel", DialogInterface.OnClickListener { dialogInterface, i ->  })
            box.show()
        }

        Q2.setOnClickListener {

            val option = arrayOf("Yellow fruit", "King of all fruit", "Not a fruit")
            val box = AlertDialog.Builder(this)
            box.setTitle("Mango is ?")
            box.setIcon(R.drawable.baseline_circle_24)
            box.setMultiChoiceItems(option, null, DialogInterface.OnMultiChoiceClickListener { dialogInterface, i, b ->

                Toast.makeText(this, "${option[i]}", Toast.LENGTH_SHORT).show()

            })
            box.setPositiveButton("Submit", DialogInterface.OnClickListener { dialogInterface, i ->  })
            box.setNegativeButton("Cancel", DialogInterface.OnClickListener { dialogInterface, i ->  })
            box.show()
        }

        Q3.setOnClickListener {

            val option = arrayOf("small in size", "is red", "is a berry")
            val box = AlertDialog.Builder(this)
            box.setTitle("Strawberry is?")
            box.setIcon(R.drawable.baseline_circle_24)
            box.setMultiChoiceItems(option, null, DialogInterface.OnMultiChoiceClickListener { dialogInterface, i, b ->

                Toast.makeText(this, "${option[i]}", Toast.LENGTH_SHORT).show()

            })
            box.setPositiveButton("Submit", DialogInterface.OnClickListener { dialogInterface, i ->  })
            box.setNegativeButton("Cancel", DialogInterface.OnClickListener { dialogInterface, i ->  })
            box.show()
        }

        Exit.setOnClickListener {
            val box = AlertDialog.Builder(this)
            box.setTitle("Exit")
            box.setIcon(R.drawable.baseline_exit_to_app_24)
            box.setMessage("Are you sure?")
            box.setPositiveButton("Exit", DialogInterface.OnClickListener { dialogInterface, i ->
                finish()
            })
            box.setNegativeButton("Cancel", DialogInterface.OnClickListener { dialogInterface, i ->

            })
            box.show()
        }
    }
}