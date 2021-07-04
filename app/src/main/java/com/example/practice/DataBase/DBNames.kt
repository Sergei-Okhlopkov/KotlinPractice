package com.example.practice.DataBase

object DBNames  {

    val TABLE_NAME = "practice"

    //Столбцы
    val COLUMN_NAME_ID = "id"
    val COLUMN_NAME_IMAGE = "image"
    val COLUMN_NAME_TEXT = "text"

    //Версия и имя
    val DATABASE_VERSION = 1
    val DATABASE_NAME = "Practice.db"

    //Содание таблицы, если не существет таковой
    val CREATE_TABLE = "CREATE TABLE IF NOT EXISTS $TABLE_NAME ("+
            "$COLUMN_NAME_ID INTEGER PRIMARY KEY,"+
            "$COLUMN_NAME_TEXT TEXT,"+
            "$COLUMN_NAME_IMAGE INTEGER)"

    val SQL_DELETE_TABLE = "DROP TABLE IF EXISTS $TABLE_NAME"


}