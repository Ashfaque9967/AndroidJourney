package com.example.listview2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    lateinit var usersarraylist : ArrayList<Users>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val name = arrayOf("Mikey", "Draken", "Baji", "Mitsuya",   "Hayashida", "Kazutora")

        val clan = arrayOf("Tokyo Manji Gang", "Tokyo Manji Gang", "Tokyo Manji Gang", "Tokyo Manji Gang", "Tokyo Manji Gang", "Tokyo Manji Gang")

        val position = arrayOf("President", "Vice-Leader","Division Captain (1st)", "Division Captain (2nd)","Division Captain (3rd)", "Division Captain (4th)")

        val phone = arrayOf("12345", "325468", "231468", "654654", "6576564", "835747")


        val imgid = intArrayOf(R.drawable.manjiro_sano, R.drawable.ken_ryuguji,R.drawable.keisuke_baji, R.drawable.takashi_mitsuya,R.drawable.haruki_hayashida,R.drawable.kazutora_hanemiya)

        usersarraylist = ArrayList()

        for (eachin in name.indices){
            val user = Users(name[eachin], clan[eachin], position[eachin], phone[eachin], imgid[eachin])

            usersarraylist.add(user)
        }
        val listview = findViewById<ListView>(R.id.mainListview)
        listview.isClickable = true
        listview.adapter = MyAdapter(this, usersarraylist)

        listview.setOnItemClickListener { adapterView, view, i, l ->

            val nameex = name[i]
            val clanex = clan[i]
            val positionex = position[i]
            val imgex = imgid[i]

            val intent = Intent(this, portfolio::class.java)

            intent.putExtra("name", nameex)
            intent.putExtra("clan", clanex)
            intent.putExtra("position", positionex)
            intent.putExtra("img", imgex)

            startActivity(intent)


        }

    }
}