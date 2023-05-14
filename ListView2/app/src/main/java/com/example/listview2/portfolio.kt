package com.example.listview2

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import de.hdodenhof.circleimageview.CircleImageView

class portfolio : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_portfolio)

        val name = intent.getStringExtra("name")
        val clan = intent.getStringExtra("clan")
        val position = intent.getStringExtra("position")
        val img = intent.getIntExtra("img", R.drawable.flag)


        val nametv = findViewById<TextView>(R.id.nametv)
        val clantv = findViewById<TextView>(R.id.clantv)
        val positiontv = findViewById<TextView>(R.id.positiontv)
        val imgtv = findViewById<CircleImageView>(R.id.imgtv)
        val button = findViewById<Button>(R.id.button)

        nametv.text = "Name: "+name
        clantv.text = "Clan: "+clan
        positiontv.text = "Position: "+position
        imgtv.setImageResource(img)

        button.setOnClickListener{

            val builder = AlertDialog.Builder(this)
            builder.setTitle("Muster")
            builder.setIcon(R.drawable.yellowswastikpng)
            builder.setMessage("This is $name $position\n\nHold on $clan is on the way")
            builder.setPositiveButton("Muster", DialogInterface.OnClickListener { dialogInterface, i ->

                Toast.makeText(this, "--Toman Forever--", Toast.LENGTH_SHORT).show()

            })
            builder.setNegativeButton("Cancle", DialogInterface.OnClickListener { dialogInterface, i ->

            })
            builder.show()

        }
    }
}