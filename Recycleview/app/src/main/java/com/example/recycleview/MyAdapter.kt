package com.example.recycleview

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class MyAdapter(var newsarr: ArrayList<news>,var context : Activity) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    private lateinit var mylistner : onitemclickerlistener
    interface onitemclickerlistener {
        fun onItemClick(position:Int)
    }

    fun setonitemclicklisterner(listner : onitemclickerlistener){
        mylistner = listner
    }

    class MyViewHolder(itemview : View, listerner : onitemclickerlistener) : RecyclerView.ViewHolder(itemview) {
        val headT = itemview.findViewById<TextView>(R.id.TVhead)
        val headimg = itemview.findViewById<ShapeableImageView>(R.id.imghead)

        init {
            itemview.setOnClickListener {
                listerner.onItemClick(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.eachitem, parent, false)
        return MyViewHolder(view, mylistner)
    }

    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {
        val currrentItem = newsarr[position]
        holder.headT.text = currrentItem.newshead
        holder.headimg.setImageResource(currrentItem.newsimg)

    }

    override fun getItemCount(): Int {
        return newsarr.size
    }
}