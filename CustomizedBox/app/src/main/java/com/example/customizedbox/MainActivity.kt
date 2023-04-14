package com.example.customizedbox

import android.annotation.SuppressLint
import android.app.Dialog
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.annotation.RequiresApi

class MainActivity : AppCompatActivity() {

    lateinit var dialogue : Dialog
    @SuppressLint("UseCompatLoadingForDrawables")
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnclick = findViewById<Button>(R.id.btnclick)

        dialogue = Dialog(this)
        dialogue.setContentView(R.layout.custom_dailogue)
        dialogue.window?.setBackgroundDrawable(getDrawable(R.drawable.bg_alertbox))


        var exit = dialogue.findViewById<Button>(R.id.btnexit)
        var stay = dialogue.findViewById<Button>(R.id.btnstay)


        exit.setOnClickListener {
            finish()
        }

        stay.setOnClickListener {
            Toast.makeText(this, "We make u stay :)", Toast.LENGTH_SHORT).show()
            dialogue.dismiss()
        }

        btnclick.setOnClickListener {
            dialogue.show()
        }


    }
}