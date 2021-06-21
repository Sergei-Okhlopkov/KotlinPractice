package com.example.practice

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class ViewPageAdapter(private var images: List<Int>)
    : RecyclerView.Adapter<ViewPageAdapter.Pager2ViewHolder>(){

    class Pager2ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val itemImage: ImageView = itemView.findViewById(R.id.itemPageView)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int): ViewPageAdapter.Pager2ViewHolder {
        return Pager2ViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.item_view_pager, parent, false))
    }

    override fun onBindViewHolder(holder: ViewPageAdapter.Pager2ViewHolder, position: Int) {
        holder.itemImage.setImageResource(images[position])
    }

    override fun getItemCount(): Int {
        return images.size
    }

  


}