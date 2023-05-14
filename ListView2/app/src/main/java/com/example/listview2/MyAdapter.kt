package com.example.listview2

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import de.hdodenhof.circleimageview.CircleImageView

class MyAdapter (val context : Activity, val arrayList: ArrayList<Users>) : ArrayAdapter<Users>(context, R.layout.eachitem, arrayList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.eachitem, null)

        val image = view.findViewById<CircleImageView>(R.id.profile_image)
        val name = view.findViewById<TextView>(R.id.name)
        val clan = view.findViewById<TextView>(R.id.Clan)
        val positionc = view.findViewById<TextView>(R.id.positionc)

        name.text = arrayList[position].name
        clan.text = arrayList[position].clan
        positionc.text = arrayList[position].position
        image.setImageResource(arrayList[position].imgid)


        return view
    }

}