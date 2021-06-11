package com.example.practice



import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class OnlyText : Fragment() {

    private var textList = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        var rv= view?.findViewById<RecyclerView>(R.id.recyclerViewOnlyText)
        rv?.layoutManager=LinearLayoutManager(context)
        rv?.adapter=RecyclerAdapter(textList)

    }

    private fun addList(text:String){
        textList.add(text)
    }

    private fun postList(){
        for (i:Int in 0..textList.size) {
            addList("item_${i}")
        }
    }

    override fun onResume() {
        super.onResume()
    }


}