package com.example.databaseapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.Data
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class Signin : AppCompatActivity() {

    companion object  {
        const val key1 = "com.exsmple.database.uniqueid"
        const val key2 = "com.exsmple.database.name"
        const val key3 = "com.exsmple.database.email"
    }

    lateinit var Database : DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

        val SeTuniqueid = findViewById<TextInputEditText>(R.id.SeTuniqueid)
        val btnsignin = findViewById<Button>(R.id.btnsignin)


        btnsignin.setOnClickListener {

            val uniqueid = SeTuniqueid.text.toString()
            if (uniqueid.isNotEmpty()){
                readData(uniqueid)
            }else{
                Toast.makeText(this, "Empty field!!", Toast.LENGTH_SHORT).show()
            }
        }

    }

    fun readData(uniqueid: String) {

        Database = FirebaseDatabase.getInstance().getReference("users")
        Database.child(uniqueid).get().addOnSuccessListener {

            if (it.exists()){
                val email = it.child("email").value
                val name = it.child("name").value
                val uniqueid = it.child("uniqueid").value

                val intent = Intent(this, Welcome::class.java)
                intent.putExtra(key3, email.toString())
                intent.putExtra(key2, name.toString())
                intent.putExtra(key1, uniqueid.toString())
                startActivity(intent)

            }
            else{
                Toast.makeText(this, "Not Found", Toast.LENGTH_SHORT).show()
            }

        }.addOnFailureListener{
            Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
        }

    }
}