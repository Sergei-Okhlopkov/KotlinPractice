package com.example.practice


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class OnlyText : Fragment() {


    private var textsList = mutableListOf<String>()



    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

       fillList()

        val rView = view?.findViewById<RecyclerView>(R.id.textRecycler)
        rView?.layoutManager = LinearLayoutManager(context)
        rView?.adapter = RecyclerAdapterOnlyText(textsList)
    }



    private fun fillList(){
        textsList = resources.getStringArray(R.array.only_text_items).toMutableList()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_only_text, container, false)
    }

}
