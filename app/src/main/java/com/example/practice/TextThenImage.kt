package com.example.practice

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class TextThenImage : Fragment() {

    private var textsList = mutableListOf<String>()

    private var imagesList = mutableListOf<Int>()
    private var names = mutableListOf<String>()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        fillText()
        fillImage()

        val rView = view?.findViewById<RecyclerView>(R.id.textThenImageRecycler)
        rView?.layoutManager = LinearLayoutManager(context)
        rView?.adapter = RecyclerAdapterTextThenImage(textsList,imagesList)
    }

    private fun addToList(image:Int){
        imagesList.add(image)
    }

    private fun fillImage() {
        names = resources.getStringArray(R.array.only_image_items).toMutableList()
        for (word in names){
            var temp:String = word
            var r: Int = getResources().getIdentifier(temp, "drawable", activity?.packageName);
            addToList(r)
        }
    }

    private fun fillText() {
        textsList = resources.getStringArray(R.array.sayings).toMutableList()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_text_then_image, container, false)
    }


}