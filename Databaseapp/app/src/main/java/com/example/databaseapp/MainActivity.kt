package com.example.databaseapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    lateinit var database : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnsignup = findViewById<Button>(R.id.btnsignup)
        val eTname = findViewById<TextInputEditText>(R.id.eTname)
        val eTuniqueid = findViewById<TextInputEditText>(R.id.eTuniqueid)
        val eTemail = findViewById<TextInputEditText>(R.id.eTemail)
        val eTpassword = findViewById<TextInputEditText>(R.id.eTpassword)
        val create = findViewById<TextView>(R.id.create)

        btnsignup.setOnClickListener {

            val name = eTname.text.toString()
            val uniqueid = eTuniqueid.text.toString()
            val email = eTemail.text.toString()
            val password = eTpassword.text.toString()

            val user = user(name, uniqueid, email, password)
            database = FirebaseDatabase.getInstance().getReference("users")
            database.child(uniqueid).setValue(user).addOnSuccessListener {
                Toast.makeText(this, "User Registered", Toast.LENGTH_SHORT).show()
            }.addOnFailureListener {
                Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
            }

        }


        create.setOnClickListener {
            val intent = Intent(this, Signin::class.java)
            startActivity(intent)
        }
    }
}