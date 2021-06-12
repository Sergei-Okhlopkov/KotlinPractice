package com.example.practice

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapterOnlyText(private var texts: List<String>) :
    RecyclerView.Adapter<RecyclerAdapterOnlyText.ViewHolder>(){

    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val itemText: TextView = itemView.findViewById(R.id.itemTextView)

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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapterOnlyText.ViewHolder {
        val v =LayoutInflater.from(parent.context).inflate(R.layout.item_only_text,parent,false)
        return ViewHolder(v)

    }

    override fun onBindViewHolder(holder: RecyclerAdapterOnlyText.ViewHolder, position: Int) {
        holder.itemText.text = texts[position]
    }

    override fun getItemCount(): Int {
        return texts.size
    }


}