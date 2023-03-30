package com.example.assignmentapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class ios_dev : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ios_dev)

        val imgclick  = findViewById<ImageView>(R.id.iosclick)

        imgclick.setOnClickListener {

            intent = Intent(applicationContext, MainActivity2::class.java)
            startActivity(intent)
        }
    }
}