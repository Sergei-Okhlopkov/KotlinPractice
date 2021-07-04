package com.example.practice.DataBase

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.provider.BaseColumns
import com.example.practice.MainActivity

class DBManager(context: Context) {



    val dbHelper= MyDbHelper(context)
    var db: SQLiteDatabase? = null

    fun openDB(){
        db = dbHelper.writableDatabase
    }

    fun closeDB(){
        dbHelper.close()
    }


    fun insertToDb(id: Int, text: String, image: Int?){

        //Загоняем то, что нужно вставить в БД
        val values = ContentValues().apply {
            put(DBNames.COLUMN_NAME_ID,id)
            put(DBNames.COLUMN_NAME_TEXT,text)
            put(DBNames.COLUMN_NAME_IMAGE, image)

        }

        //Производим вставку данных
        db?.insert(DBNames.TABLE_NAME, null,values)
    }

    fun deleteFromDb(id: String){
        val selection = DBNames.COLUMN_NAME_ID + "=$id"
        db?.delete(DBNames.TABLE_NAME, selection,null)
    }

    fun readDbData(): ArrayList<MainActivity.DataBaseReturn>{
        val dataList = ArrayList<MainActivity.DataBaseReturn>()


        // В курсоре есть разхные сортировки, можно использовать для настраиваемого поиска
        val cursor = db?.query(DBNames.TABLE_NAME, null, null, null,
            null, null, null)


        //перебираем данные по очереди

            while (cursor?.moveToNext()!!){//если элементы закончились, то мы выходим из функции

                //Получаем у каждого id его текст
                val Text=cursor?.getString(cursor.getColumnIndex(DBNames.COLUMN_NAME_TEXT))

                //Получаем у каждого элемента id
                val Id=cursor?.getString(cursor.getColumnIndex(DBNames.COLUMN_NAME_ID))

                //Получаем у каждого элемента картинку
                val Image= cursor?.getInt(cursor.getColumnIndex(DBNames.COLUMN_NAME_IMAGE))

                var item = MainActivity.DataBaseReturn()
                item.id=Id
                item.text=Text
                item.image = Image

                dataList.add(item)

            }
        cursor.close()


        return dataList
    }

    fun searchDbData(searchId: String): ArrayList<MainActivity.DataBaseReturn>{
        val dataList = ArrayList<MainActivity.DataBaseReturn>()
        val selection = "${DBNames.COLUMN_NAME_ID} like ?"

        // В курсоре есть разхные сортировки, можно использовать для настраиваемого поиска
        val cursor = db?.query(DBNames.TABLE_NAME, null, selection, arrayOf(searchId),
            null, null, null)


        //перебираем данные по очереди

        while (cursor?.moveToNext()!!){//если элементы закончились, то мы выходим из функции

            //Получаем у каждого id его текст
            val Text=cursor?.getString(cursor.getColumnIndex(DBNames.COLUMN_NAME_TEXT))

            //Получаем у каждого элемента id
            val Id=cursor?.getString(cursor.getColumnIndex(DBNames.COLUMN_NAME_ID))

            //Получаем у каждого элемента картинку
            val Image= cursor?.getInt(cursor.getColumnIndex(DBNames.COLUMN_NAME_IMAGE))

            var item = MainActivity.DataBaseReturn()
            item.id=Id
            item.text=Text
            item.image = Image

            dataList.add(item)

        }
        cursor.close()


        return dataList
    }

}