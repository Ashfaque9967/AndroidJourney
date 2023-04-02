package com.example.splashscreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView

class Basicinfo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basicinfo)

        supportActionBar?.hide()

        var months = arrayOf("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December")

        var genders = arrayOf("Male", "Female", "Rather not say")

        val autocommonths : AutoCompleteTextView = findViewById(R.id.autocompltemonths)
        val autocomgender : AutoCompleteTextView = findViewById(R.id.autocompltegender)

        // list adapter for months
        val adaptermonths = ArrayAdapter(this, R.layout.list_items,months)

        autocommonths.setAdapter(adaptermonths)


        autocommonths.onItemClickListener = AdapterView.OnItemClickListener{adapterView, view, i, l ->

            val Selectemonth = adapterView.getItemAtPosition(i)
        }

        // list adapter for genders
        val adaptergender = ArrayAdapter(this, R.layout.genders,genders)

        autocomgender.setAdapter(adaptergender)

        autocomgender.onItemClickListener = AdapterView.OnItemClickListener{adapterView, view, i, l ->

            val Selectedyear = adapterView.getItemAtPosition(i)
        }

    }
}