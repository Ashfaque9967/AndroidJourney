package com.example.listview

import android.annotation.SuppressLint
import android.app.Dialog
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.textfield.TextInputEditText

lateinit var Dialog : Dialog
class MainActivity : AppCompatActivity() {
    @SuppressLint("UseCompatLoadingForDrawables", "MissingInflatedId")
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listview = findViewById<ListView>(R.id.listview)
        val add = findViewById<FloatingActionButton>(R.id.btnadd)

        val taskslist = arrayListOf<String>()
        taskslist.add("Reading")
        taskslist.add("Exercise")
        taskslist.add("College")
        taskslist.add("Work")
        taskslist.add("Exercise")
        taskslist.add("Self Learning")

        val LV_adp = ArrayAdapter(this, android.R.layout.simple_list_item_1, taskslist)
        listview.adapter = LV_adp

        listview.setOnItemClickListener { adapterView, view, i, l ->
            val text = (view as TextView).text.toString()

            Toast.makeText(this, text, Toast.LENGTH_SHORT).show()

        }


        Dialog = Dialog(this)
        Dialog.setContentView(R.layout.add_alertbox)
        Dialog.window?.setBackgroundDrawable(getDrawable(R.drawable.alrtboxbg))

        val alrtbtnadd = Dialog.findViewById<Button>(R.id.alrtbtnadd)
        val inputtext = Dialog.findViewById<TextInputEditText>(R.id.inputtext)

        alrtbtnadd.setOnClickListener{

            var text = inputtext.text.toString()
            taskslist.add(text)
            Toast.makeText(this, text+" Add!", Toast.LENGTH_SHORT).show()
            Dialog.dismiss()
            inputtext.text?.clear()

        }

        add.setOnClickListener{

            Dialog.show()

        }


    }
}