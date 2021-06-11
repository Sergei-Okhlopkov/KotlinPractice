package com.example.practice



import android.os.Bundle
import android.telecom.PhoneAccountHandle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView


class MainActivity : AppCompatActivity() {

    private lateinit var togglethis: ActionBarDrawerToggle

    override fun onStart() {
        super.onStart()
        initFunc()
    }

    private fun initFunc(){
        supportFragmentManager.beginTransaction()
            .replace(R.id.dataContainer,OnlyText()).commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val drawerLayout = findViewById<DrawerLayout>(R.id.drawerLayout)

        togglethis= ActionBarDrawerToggle(this, drawerLayout, R.string.open,R.string.close)
        drawerLayout.addDrawerListener(togglethis)

        togglethis.syncState()//говорим  togglethis что оно ещё не готово к использованию


        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val navigationView = findViewById<NavigationView>(R.id.navigationView)

//        navigationView.setNavigationItemSelectedListener {
//            when (it.itemId) {
//
//            }
//            true
//        }

//        supportActionBar?.hide()
//        android.R.style.Theme_Black // тёмная тема
//
//        //listView с меню
//        //обращаемся к ListView по его id
//        val listView = findViewById<ListView>(R.id.listMenu)
//
//
//        //Массив с пунктами меню
//        val menuNames = resources.getStringArray(R.array.menu_names)
//
//        val adapter: ArrayAdapter<String> = ArrayAdapter<String>(
//            this,
//            android.R.layout.simple_list_item_1, menuNames
//        )
//
//        listView.adapter = adapter

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (togglethis.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }


}