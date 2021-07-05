package com.example.practice

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.practice.DataBase.DBManager
import com.example.practice.DataBase.DBNames
import java.util.Random


class DataBaseShow(context: Context) : Fragment() {



    val DBMan = DBManager(context)
    val myAdapter = RecyclerDataBaseShow(ArrayList())

    var desc: EditText? =null
    var image: Int? = null
    var id: EditText? = null
    var findId: EditText? = null
    var recycler: RecyclerView? = null





    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initRecyclerView()

        val btnCreate: Button? = view?.findViewById(R.id.btnCreate)
        val btnDelete: Button? = view?.findViewById(R.id.btnDelete)
        val btnFind: Button? = view?.findViewById(R.id.btnFind)
        findId = view?.findViewById(R.id.editFind)

        desc = view?.findViewById<EditText>(R.id.createText)
        image = randomImage()
        id = view?.findViewById<EditText>(R.id.createOrDelId)

        btnCreate?.setOnClickListener {
            if (desc?.text.toString().isEmpty() || id?.text.toString().isEmpty()){
                val textToast = "Заполните поля новый ID и Текст"
                val duration = Toast.LENGTH_SHORT
                Toast.makeText(context, textToast, duration).show()
            }else{
                //вставляем запись в бд
                // TODO: Тут должна быть функция, которая проверяет на уникальность id
                val newId: ArrayList<MainActivity.DataBaseReturn> = DBMan.searchDbData(id?.text.toString())

              if (newId.isNotEmpty()) {
                    val textToast = "Запись с таким id уже существует"
                    val duration = Toast.LENGTH_SHORT
                    Toast.makeText(context, textToast, duration).show()
                 }else {
                  DBMan.insertToDb(id?.text.toString().toInt(),desc?.text.toString(),image)
                  fillRecyclerAdapter()
                  initRecyclerView()

                  //очищаем поля после занесения записи в БД
                  clearInput()
              }







            }
        }

        btnDelete?.setOnClickListener {
            if (id?.text.toString().isNotEmpty()){

                DBMan.deleteFromDb(id?.text.toString())
                if (myAdapter.itemCount==1) myAdapter.updateAdapter(DBMan.searchDbData(id?.text.toString()))
                else {
                    fillRecyclerAdapter()
                    initRecyclerView()
                }


                clearInput()

            }else{
                val textToast = "Введите id элемента для удаления"
                val duration = Toast.LENGTH_SHORT
                Toast.makeText(context, textToast, duration).show()
            }

        }

        btnFind?.setOnClickListener {
            if (findId?.text.toString().isEmpty()){
                fillRecyclerAdapter()
                initRecyclerView()
            }else{
                myAdapter.updateAdapter(DBMan.searchDbData(findId?.text.toString()))
                clearInput()
            }

        }



    }


    override fun onResume() {
        super.onResume()
        DBMan.openDB()
        fillRecyclerAdapter()
    }

    override fun onDestroy() {
        super.onDestroy()
        DBMan.closeDB()

    }

    private fun clearInput(){
        desc?.text?.clear()
        id?.text?.clear()
        findId?.text?.clear()
    }

    private fun randomImage(): Int? {
        //Метод возвращает ссылку на рандомную картинку
       // var random= (0 until  8).random()
        var random= Random().nextInt(7)
        var names = resources.getStringArray(R.array.only_image_items).toMutableList()
        return  getResources().getIdentifier(names[random], "drawable", activity?.packageName)
    }

    fun initRecyclerView(){
        recycler = view?.findViewById(R.id.baseRecycler)
        recycler?.layoutManager = LinearLayoutManager(context)
        recycler?.adapter = myAdapter

    }

    fun fillRecyclerAdapter(){
        myAdapter.updateAdapter(DBMan.readDbData())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initRecyclerView()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_data_base_show, container, false)
    }






}