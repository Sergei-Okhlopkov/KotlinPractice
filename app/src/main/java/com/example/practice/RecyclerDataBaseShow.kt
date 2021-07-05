package com.example.practice

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerDataBaseShow(private var listArray: ArrayList<MainActivity.DataBaseReturn>):
    RecyclerView.Adapter<RecyclerDataBaseShow.ViewHolder>() {

    var mainList = listArray

    class ViewHolder (itemView: View):RecyclerView.ViewHolder(itemView){

        val itemImage: ImageView = itemView.findViewById(R.id.itemImageDB)
        val itemId: TextView = itemView.findViewById(R.id.itemIdDB)
        val itemText: TextView = itemView.findViewById(R.id.itemTextDB)

        fun setData(setDataItem: MainActivity.DataBaseReturn){
            itemText.text = setDataItem.text
            itemId.text = setDataItem.id
            itemImage.setImageResource(setDataItem.image)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_data_base_recycler,parent,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.setData(mainList.get(position))

    }

    override fun getItemCount(): Int {
       return mainList.size
    }

    fun updateAdapter(mainItems: ArrayList<MainActivity.DataBaseReturn>)  {

        //как только данные изменились, то даем новые, затем уведомляем RecycylerView

        mainList.clear()
        mainList.addAll(mainItems)
        notifyDataSetChanged()//Уведомляем RecycylerView

    }





}