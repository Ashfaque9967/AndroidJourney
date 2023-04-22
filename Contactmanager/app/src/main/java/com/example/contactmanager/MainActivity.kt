package com.example.contactmanager

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.Data
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    lateinit var DatabaseReference :DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

        val inptnumber = intent.getStringExtra(Login.key1)
        val inptname = intent.getStringExtra(Login.key)
        val nametop = findViewById<TextView>(R.id.numbermain)
        nametop.text = inptname.toString()

        val nametoAdd = findViewById<TextInputEditText>(R.id.nameToAdd)
        val numbertoadd = findViewById<TextInputEditText>(R.id.numberToAdd)
        val btnadd = findViewById<Button>(R.id.addcontact)

        btnadd.setOnClickListener {

            val name = nametoAdd.text.toString()
            val number = numbertoadd.text.toString()

            val contacts = contact(name, number)

            DatabaseReference = FirebaseDatabase.getInstance().getReference("users/$inptnumber")
            DatabaseReference.child("Contact/$name").setValue(contacts).addOnSuccessListener {
                Toast.makeText(this, "Contact Added", Toast.LENGTH_SHORT).show()
            }.addOnFailureListener{
                Toast.makeText(this, "failed!!", Toast.LENGTH_SHORT).show()
            }
        }

        val btnfindconin = findViewById<Button>(R.id.btnFind)
        val toFindCon = findViewById<TextInputEditText>(R.id.Findin)

        btnfindconin.setOnClickListener {

            val name = toFindCon.text.toString()
            if(name.isEmpty()){
                Toast.makeText(this, "Empty Field!", Toast.LENGTH_SHORT).show()
            }else{
                read(name, inptnumber.toString())
            }


        }

    }

    @SuppressLint("SetTextI18n")
    private fun read(name: String, number :String) {

        DatabaseReference = FirebaseDatabase.getInstance().getReference("users/$number/Contact")
        DatabaseReference.child(name).get().addOnSuccessListener {

            if (it.exists()){
                val number = it.child("number").value

                val numbertext = findViewById<TextView>(R.id.numtext)
                numbertext.text = "Number: " + number

            }
        }
    }
}