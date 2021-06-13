package com.example.practice


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class OnlyImage : Fragment() {

    private var imagesList = mutableListOf<Int>()
    private var names = mutableListOf<String>()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        fillList()

        val rView = view?.findViewById<RecyclerView>(R.id.imageRecycler)
        rView?.layoutManager = LinearLayoutManager(context)
        rView?.adapter = RecyclerAdapterOnlyImage(imagesList)
    }

    private fun addToList(image:Int){
        imagesList.add(image)
    }

    private fun fillList(){
        names = resources.getStringArray(R.array.only_image_items).toMutableList()
        for (word in names){
            var temp:String = word
            var r: Int = getResources().getIdentifier(temp, "drawable", activity?.packageName);
            addToList(r)
        }


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_only_image, container, false)
    }


}