package com.example.practice

import android.graphics.drawable.Drawable
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapterOnlyImage(private var images: List<Int>) :
    RecyclerView.Adapter<RecyclerAdapterOnlyImage.ViewHolder>() {

        class ViewHolder (itemView: View):RecyclerView.ViewHolder(itemView){
            val itemImage: ImageView = itemView.findViewById(R.id.itemImageView)

            init{
                //Выводим сообщение, что мы нажали на элемент recyclerView
//            itemView.setOnClickListener { v: View ->
//                val position: Int = adapterPosition
//                Toast.makeText(
//                    itemView.context,
//                    "Вы нажали на кнопку ${postion + 1}",
//                    Toast.LENGTH_SHORT
//                ).show()
//            }
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_only_image,parent,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemImage.setImageResource(images[position])
    }

    override fun getItemCount(): Int {
        return images.size
    }


}