package com.example.assignmentapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class android_dev : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_android_dev)

        val imgclickable = findViewById<ImageView>(R.id.imageView)

        imgclickable.setOnClickListener {

            intent = Intent(applicationContext, MainActivity2::class.java)
            startActivity(intent)
        }
    }
}