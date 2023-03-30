package com.example.assignmentapp

import android.content.Intent
import android.content.Intent.ACTION_CALL_BUTTON
import android.content.Intent.ACTION_DIAL
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.LinearLayout

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val andclickable = findViewById<LinearLayout>(R.id.child1)
        val iosclickable = findViewById<LinearLayout>(R.id.child2)
        val aiclickable = findViewById<LinearLayout>(R.id.child3)
        val webclickable = findViewById<LinearLayout>(R.id.child4)
        val devopsclickable = findViewById<LinearLayout>(R.id.child5)
        val mlclickable = findViewById<LinearLayout>(R.id.child6)
        val btncontact = findViewById<Button>(R.id.contact)

        andclickable.setOnClickListener {

            intent = Intent(applicationContext, android_dev::class.java)
            startActivity(intent)
        }
        iosclickable.setOnClickListener {

            intent = Intent(applicationContext, ios_dev::class.java)
            startActivity(intent)
        }
        aiclickable.setOnClickListener {

            intent = Intent(applicationContext, Ai_dev::class.java)
            startActivity(intent)
        }
        webclickable.setOnClickListener {

            intent = Intent(applicationContext, Web_Dev::class.java)
            startActivity(intent)
        }
        devopsclickable.setOnClickListener {

            intent = Intent(applicationContext, Dev0ps::class.java)
            startActivity(intent)
        }
        mlclickable.setOnClickListener {

            intent = Intent(applicationContext, ML_dev::class.java)
            startActivity(intent)
        }
        btncontact.setOnClickListener {

            intent = Intent(ACTION_DIAL)
            intent.setData(Uri.parse("tel: 9321602175"))
            startActivity(intent)
        }
    }
}