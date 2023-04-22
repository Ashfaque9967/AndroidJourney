package com.example.contactmanager

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import org.w3c.dom.Text

class Login : AppCompatActivity() {

    lateinit var databaseReference: DatabaseReference

    companion object{
        const val key =  "com.example.contactmanager.MainActivity.name"
        const val key1 =  "com.example.contactmanager.MainActivity.number"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        supportActionBar?.hide()

        val createnew = findViewById<TextView>(R.id.createnew)

        createnew.setOnClickListener {
            val intent = Intent(this, Signup::class.java)
            startActivity(intent)
        }

        val btnsignin = findViewById<Button>(R.id.btnsignin)
        val phone_num = findViewById<TextInputEditText>(R.id.eTnumberlog)
        val passwordlog = findViewById<TextInputEditText>(R.id.eTpasswordlog)

        btnsignin.setOnClickListener {

            val phone = phone_num.text.toString()
            val password = passwordlog.text.toString()
            if (phone.isEmpty() || password.isEmpty()){
                Toast.makeText(this, "Empty Fields", Toast.LENGTH_SHORT).show()
            }else{
                readData(phone, password)
            }

        }

    }

    fun readData(number: String, password : String) {


        databaseReference = FirebaseDatabase.getInstance().getReference("users")
        databaseReference.child(number).get().addOnSuccessListener {

            if (it.exists()){
                val DBpassword = it.child("password").value
                val DBnumber = it.child("number").value
                val DBname = it.child("name").value

                if (number == DBnumber && password == DBpassword){
                    val intent = Intent(this, MainActivity::class.java)
                    intent.putExtra(key, DBname.toString())
                    intent.putExtra(key1, DBnumber.toString())

                    startActivity(intent)
                }
            }
            else{
                Toast.makeText(this, "Not Found!!", Toast.LENGTH_SHORT).show()
            }



        }.addOnFailureListener{
            Toast.makeText(this, "Failed!", Toast.LENGTH_SHORT).show()
        }
    }
}