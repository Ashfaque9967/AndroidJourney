package com.example.logcat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val text = findViewById<TextView>(R.id.text)

        text.setOnClickListener {
            intent = Intent(applicationContext, MainActivity2::class.java)
            startActivity(intent)
        }
    }
}