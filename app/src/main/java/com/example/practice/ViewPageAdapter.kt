package com.example.practice



import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
<<<<<<< HEAD
import androidx.recyclerview.widget.RecyclerView

class ViewPageAdapter(private var texts: List<String>,private var images: List<Int>)
    : RecyclerView.Adapter<ViewPageAdapter.Pager2ViewHolder>(){

    class Pager2ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val itemText: TextView = itemView.findViewById(R.id.itemTextPageView)
        val itemImage: ImageView = itemView.findViewById(R.id.itemImagePageView)
=======

import androidx.recyclerview.widget.RecyclerView



class ViewPageAdapter(/*private var texts: List<String>*/ private var images: List<Int>)
    : RecyclerView.Adapter<ViewPageAdapter.Pager2ViewHolder>(){

    class Pager2ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val itemImage: ImageView = itemView.findViewById(R.id.itemImagePageView)
        //val itemText: TextView = itemView.findViewById(R.id.itemTextPageView)
>>>>>>> main
    }

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int): ViewPageAdapter.Pager2ViewHolder {
        return Pager2ViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.item_view_pager, parent, false))
    }

    override fun onBindViewHolder(holder: ViewPageAdapter.Pager2ViewHolder, position: Int) {
        holder.itemImage.setImageResource(images[position])
<<<<<<< HEAD
        holder.itemText.text = texts[position]
=======
        //holder.itemText.text = texts[position]
>>>>>>> main
    }

    override fun getItemCount(): Int {
        return images.size
    }




}