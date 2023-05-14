package com.example.recycleview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var myRecycleview:RecyclerView
    lateinit var newsArr : ArrayList<news>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myRecycleview= findViewById(R.id.Recycleview)

        val newsImageArray = arrayOf(
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3,
            R.drawable.img4,
            R.drawable.img5,
            R.drawable.img6,
        )

        val newsHeadingArray = arrayOf(
            "U.K. Foreign Secretary James Cleverly raises issue of BBC tax searches with EAM Jaishankar",
            "Cooking gas prices hiked by ₹50 for domestic, ₹350.50 for commercial cylinders",
            "Joe Biden appoints two prominent Indian-American corporate leaders to his Export Council",
            "Sergey Lavrov will raise suspected bombing of Nord Stream II at G20: Russian Foreign Ministry",
            "Belarusian leader Lukashenko visits China amid Ukraine tensions",
            "China rips new U.S. House committee on countering Beijing"

        )

        val newscontent = arrayOf(
            getString(R.string.news_content),getString(R.string.news_content),
            getString(R.string.news_content),getString(R.string.news_content),
            getString(R.string.news_content),getString(R.string.news_content)
        )

        myRecycleview.layoutManager = LinearLayoutManager(this)
        newsArr = arrayListOf<news>()

        for (index in newsHeadingArray.indices){

            val new  = news(newsHeadingArray[index], newsImageArray[index], newscontent[index])
            newsArr.add(new)
        }

        var myAdapter = MyAdapter(newsArr, this)
        myRecycleview.adapter = myAdapter
        myAdapter.setonitemclicklisterner(object : MyAdapter.onitemclickerlistener{
            override fun onItemClick(position: Int) {
                // on clicking each item what u want to perform

                val intent = Intent(applicationContext, details_n_description::class.java)
                intent.putExtra("heading", newsArr[position].newshead)
                intent.putExtra("imgid", newsArr[position].newsimg)
                intent.putExtra("content", newsArr[position].newsContent)
                startActivity(intent)
            }


        })

    }
}