package com.example.practice

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter (private val textViews: List<String>) : RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {


    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val onlyText: TextView= itemView.findViewById(R.id.onlyText)


        init {
            itemView.setOnClickListener { v: View ->
                val position: Int = adapterPosition
                Toast.makeText(
                    itemView.context, "Вы нажали на пункт меню ${position + 1}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_only_text, parent, false)
        return MyViewHolder(v)
    }

    // заполняем view
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.onlyText.text = textViews[position]
    }

    //получаем размер массива элементов, который выводится
    override fun getItemCount() = textViews.size

}