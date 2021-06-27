package com.example.practice



import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.Window
import android.webkit.WebView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView


class MainActivity : AppCompatActivity() {

    private lateinit var togglethis: ActionBarDrawerToggle

    override fun onStart() {
        super.onStart()

        //устанавливаем цвет statusBar
        val window: Window = getWindow()
        window.setStatusBarColor(ContextCompat.getColor(this,R.color.black))

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

    private fun showImageAndText(){
        val fImageAndText:Fragment=ImageAndText()
        var fTransaction: Int =supportFragmentManager.beginTransaction()
            .replace(R.id.dataContainer,fImageAndText).commit()
    }

    private fun showTextThenImage(){
        val fTextThenImage:Fragment=TextThenImage()
        var fTransaction: Int =supportFragmentManager.beginTransaction()
            .replace(R.id.dataContainer,fTextThenImage).commit()
        
    }

    private fun showViewPager(){
        val fViewPager:Fragment=ViewPager()
        var fTransaction: Int =supportFragmentManager.beginTransaction()
            .replace(R.id.dataContainer,fViewPager).commit()

    }

    private fun showNotifications(){
        val fNotifications:Fragment=Notifications(this)
        var fTransaction: Int =supportFragmentManager.beginTransaction()
            .replace(R.id.dataContainer,fNotifications).commit()
    }

    private fun showChoosePhoto(){
        val fChoosePhoto:Fragment=ChoosePhoto()
        var fTransaction: Int =supportFragmentManager.beginTransaction()
            .replace(R.id.dataContainer,fChoosePhoto).commit()
    }

    private fun showWebView(){
        val fWebView:Fragment=WebViewer()
        var fTransaction: Int =supportFragmentManager.beginTransaction()
            .replace(R.id.dataContainer,fWebView).commit()
    }

    private fun changeTitle(title: String){

        supportActionBar?.title = title

    }

    override fun onBackPressed() {
        val w:WebView = findViewById<WebView>(R.id.webView)
        if (w.canGoBack()) w.goBack()
        else super.onBackPressed()
    }



    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val drawerLayout = findViewById<DrawerLayout>(R.id.drawerLayout)

        togglethis= ActionBarDrawerToggle(this, drawerLayout, R.string.open,R.string.close)
        drawerLayout.addDrawerListener(togglethis)

        togglethis.syncState()//говорим  togglethis что оно ещё не готово к использованию


        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //устанавливаем цвет actionBar
        val colorDrawable: ColorDrawable = ColorDrawable(Color.parseColor("#5C5231"))
        supportActionBar?.apply {setBackgroundDrawable(colorDrawable)}



        val navigationView = findViewById<NavigationView>(R.id.navigationView)

        navigationView.setNavigationItemSelectedListener() {
            when (it.itemId) {
                R.id.menu_1 -> {
                    showOnlyText()
                    changeTitle("Только текст")
                }
                R.id.menu_2 -> {
                    showOnlyImage()
                    changeTitle("Только картинка")
                }
                R.id.menu_3 ->  {
                    showImageAndText()
                    changeTitle("Картинка и текст")
                }
                R.id.menu_4 -> {
                    showTextThenImage()
                    changeTitle("Текст/картинка по очереди")
                }
                R.id.menu_5 -> {
                    showViewPager()
                    changeTitle("ViewPager")
                }
                R.id.menu_6 -> {
                    showNotifications()
                    changeTitle("Уведомления")
                }
                R.id.menu_7 -> {
                    showChoosePhoto()
                    changeTitle("Выбор фотографии")
                }
                R.id.menu_8 -> {
                    showWebView()
                    changeTitle("WebView")
                }

            }
            //закрываем меню, при выборе пункта
            drawerLayout.closeDrawer(GravityCompat.START)
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