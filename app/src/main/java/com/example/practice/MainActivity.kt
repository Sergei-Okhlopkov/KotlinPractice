package com.example.practice



import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.FrameLayout
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.navigation.NavigationView


class MainActivity : AppCompatActivity() {

    private lateinit var togglethis: ActionBarDrawerToggle

    override fun onStart() {
        super.onStart()

    }


    private fun showOnlyText(){
        val fOnlyText:Fragment=OnlyText()
        var fTransaction: Int = supportFragmentManager.beginTransaction()
            .replace(R.id.dataContainer, fOnlyText).commit()


    }

    private fun showOnlyImage(){
        val fOnlyImage:Fragment=OnlyImage()
        var fTransaction: Int = supportFragmentManager.beginTransaction()
            .replace(R.id.dataContainer, fOnlyImage).commit()


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

        navigationView.setNavigationItemSelectedListener() {
            when (it.itemId) {
            R.id.menu_1 -> showOnlyText()
            R.id.menu_2 -> showOnlyImage()

            }
            true
        }

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