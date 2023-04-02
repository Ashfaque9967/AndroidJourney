package com.example.splashscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        supportActionBar?.hide()

        val btnnext = findViewById<Button>(R.id.next)

        btnnext.setOnClickListener {
            val intent = Intent(this, Basicinfo::class.java)
            startActivity(intent)
        }
    }
}