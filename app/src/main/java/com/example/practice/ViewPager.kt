package com.example.practice

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import me.relex.circleindicator.CircleIndicator3


class ViewPager : Fragment() {

    private var imagesList = mutableListOf<Int>()
    private var names = mutableListOf<String>()
<<<<<<< HEAD
<<<<<<< HEAD
    private var textsList = mutableListOf<String>()
=======
    //private var textsList = mutableListOf<String>()
>>>>>>> main
=======
    //private var textsList = mutableListOf<String>()
>>>>>>> main

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

<<<<<<< HEAD
<<<<<<< HEAD


        fillText()
        fillImage()

        val view_pager_2: ViewPager2? = view?.findViewById<ViewPager2>(R.id.viewPager)
        view_pager_2?.adapter = ViewPageAdapter(textsList, imagesList)
=======
=======
>>>>>>> main
        fillList()
        fillImage()

        val view_pager_2: ViewPager2? = view?.findViewById<ViewPager2>(R.id.viewPager)
        view_pager_2?.adapter = ViewPageAdapter(/*textsList,*/imagesList)
<<<<<<< HEAD
>>>>>>> main
=======
>>>>>>> main
        view_pager_2?.orientation = ViewPager2.ORIENTATION_HORIZONTAL


        //Индикатор - на какой картинке находимся (кружочки)
        val indicator= view?.findViewById<CircleIndicator3>(R.id.circleIndicatorOfViewPager)
        indicator?.setViewPager(view_pager_2)
        //indicator?.setBackgroundColor(resources.getColor(R.color.brown))



        //fake swipe вправо и влево
        val btnNext: Button? = view?.findViewById(R.id.btnNext)
        val btnPrev: Button? = view?.findViewById(R.id.btnPrev)

        btnNext?.setOnClickListener{
            view_pager_2?.apply{
                beginFakeDrag()
                fakeDragBy(-100f)
                endFakeDrag()
            }
        }

        btnPrev?.setOnClickListener{
            view_pager_2?.apply{
                beginFakeDrag()
                fakeDragBy(100f)
                endFakeDrag()
            }
        }


    }

    private fun fillList(){
       // textsList = resources.getStringArray(R.array.only_image_items).toMutableList()
    }

    private fun addToList(image:Int){
        imagesList.add(image)
    }

    private fun fillImage() {
        names = resources.getStringArray(R.array.only_image_items).toMutableList()
        for (word in names){
            val temp:String = word
            val r: Int = getResources().getIdentifier(temp, "drawable", activity?.packageName);
            addToList(r)
        }
    }

    private fun fillText(){
        textsList = resources.getStringArray(R.array.only_image_items).toMutableList()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_view_pager, container, false)
    }


}