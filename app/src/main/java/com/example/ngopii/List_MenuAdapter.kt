package com.example.ngopii

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView

class List_MenuAdapter (var mContext: Context, var resources: Int, var items: List<List_Menu>):
                        ArrayAdapter<List_Menu>(mContext, resources, items) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater:LayoutInflater = LayoutInflater.from(mContext)
        val view:View = layoutInflater.inflate(resources, null)

        val foto_menu:ImageView = view.findViewById(R.id.foto_menu)
        val nama_menu:TextView = view.findViewById(R.id.nama_menu)
        val harga_menu:TextView = view.findViewById(R.id.harga_menu)
        var rating:RatingBar = view.findViewById(R.id.rating)

        val mItem:List_Menu = items[position]
        foto_menu.setImageDrawable(mContext.resources.getDrawable(mItem.foto_menu))
        nama_menu.text = mItem.nama_menu
        harga_menu.text = mItem.harga_menu
        rating.rating = mItem.rating.toFloat()

        return view
    }
}