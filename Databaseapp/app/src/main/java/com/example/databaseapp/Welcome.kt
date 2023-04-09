package com.example.databaseapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Welcome : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        val mail = intent.getStringExtra(Signin.key3)
        val uniqueid = intent.getStringExtra(Signin.key1)
        val name = intent.getStringExtra(Signin.key2)

        val welcomeText = findViewById<TextView>(R.id.weltxt)
        val mailtxt = findViewById<TextView>(R.id.btnmail)
        val uniquetxt = findViewById<TextView>(R.id.btnunique)

        welcomeText.text = "Welcome $name"
        mailtxt.text = "Mail : $mail"
        uniquetxt.text = "unique : $uniqueid"

    }
}