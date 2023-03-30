package com.example.assignmentapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class Web_Dev : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_dev)

        val imgclick = findViewById<ImageView>(R.id.imgclick)

        imgclick.setOnClickListener {

            intent = Intent(applicationContext, MainActivity2::class.java)
            startActivity(intent)

        }

    }
}