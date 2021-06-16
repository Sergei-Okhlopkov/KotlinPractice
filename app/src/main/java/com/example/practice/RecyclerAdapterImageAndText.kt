package com.example.practice

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapterImageAndText(private var texts: List<String>, private var images: List<Int>):
    RecyclerView.Adapter<RecyclerAdapterImageAndText.ViewHolder>() {


    class ViewHolder (itemView: View):RecyclerView.ViewHolder(itemView){
        val itemImage: ImageView = itemView.findViewById(R.id.itemImageAndTextView)
        val itemText: TextView = itemView.findViewById(R.id.itemTextAndImageView)

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
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_image_and_text,parent,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemText.text = texts[position]
        holder.itemImage.setImageResource(images[position])
    }

    override fun getItemCount(): Int {
        return images.size
    }
}