package com.example.assignmentapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class Dev0ps : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dev0ps)

        val devopsclick = findViewById<ImageView>(R.id.devopsclick)

        devopsclick.setOnClickListener {
            intent= Intent(applicationContext, MainActivity2::class.java)
            startActivity(intent)
        }
    }
}