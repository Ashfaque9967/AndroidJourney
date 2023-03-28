package com.example.intents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import androidx.cardview.widget.CardView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnnextAct = findViewById<Button>(R.id.button)
        val cardCam = findViewById<CardView>(R.id.CardCam)

        cardCam.setOnClickListener {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivity(intent)
        }

        btnnextAct.setOnClickListener {
            // open a new activity

            intent= Intent(applicationContext, MainActivity2::class.java, )
            startActivity(intent)
        }
    }
}