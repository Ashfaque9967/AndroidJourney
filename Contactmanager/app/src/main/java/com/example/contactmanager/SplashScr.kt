package com.example.contactmanager

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashScr : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_scr)

        supportActionBar?.hide()

        Handler().postDelayed({
            intent = Intent(this, Login::class.java)
            startActivity(intent)
            finish()
        }, 1500)
    }
}