package com.example.assignmentapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class ML_dev : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ml_dev)

        val mldevclick = findViewById<ImageView>(R.id.mldevclick)

        mldevclick.setOnClickListener {

            intent = Intent(applicationContext, MainActivity2::class.java)
            startActivity(intent)
        }
    }
}