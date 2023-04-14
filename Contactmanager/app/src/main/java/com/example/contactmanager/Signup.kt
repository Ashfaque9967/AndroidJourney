package com.example.contactmanager

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.core.graphics.red
import androidx.core.graphics.toColor
import androidx.core.widget.doOnTextChanged
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class Signup : AppCompatActivity() {
    lateinit var database : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        supportActionBar?.hide()


        val btnsignup = findViewById<Button>(R.id.btnsignup)
        val eTname = findViewById<TextInputEditText>(R.id.eTname)
        val eTnumber = findViewById<TextInputEditText>(R.id.eTnumber)
        val eTrepassword = findViewById<TextInputEditText>(R.id.eTrepassword)

        btnsignup.setOnClickListener {

            val name = eTname.text.toString()
            val number = eTnumber.text.toString()
            val password = eTrepassword.text.toString()

            val user = user(name, number, password)
            database = FirebaseDatabase.getInstance().getReference("users")
            database.child(number).setValue(user).addOnSuccessListener {
                Toast.makeText(this, "User registered", Toast.LENGTH_SHORT).show()
            }.addOnFailureListener{
                Toast.makeText(this, "Failed!", Toast.LENGTH_SHORT).show()
            }

            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }


    }
}