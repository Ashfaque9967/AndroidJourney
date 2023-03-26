package com.example.interaction

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnDark = findViewById<Button>(R.id.btnDark)
        val btnLight = findViewById<Button>(R.id.btnwhite)
        val btnRead = findViewById<Button>(R.id.btnread)
        val Layout = findViewById<LinearLayout>(R.id.LinearLayout)


        btnRead.setOnClickListener {
            // change the theme to read mode
            Layout.setBackgroundResource(R.color.yellow)
        }

        btnDark.setOnClickListener {
            // change the theme to dark mode
            Layout.setBackgroundResource(R.color.black)
        }
        btnLight.setOnClickListener {
            // change the theme to dark mode
            Layout.setBackgroundResource(R.color.white)
        }
    }
}