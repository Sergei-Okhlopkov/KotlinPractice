package com.example.practice.DataBase

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyDbHelper(context: Context) : SQLiteOpenHelper(context, DBNames.DATABASE_NAME, null,
    DBNames.DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase?) {
       db?.execSQL(DBNames.CREATE_TABLE)
    }


    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL(DBNames.SQL_DELETE_TABLE)
        onCreate(db)
    }
}