package com.example.practice

import android.annotation.SuppressLint
import android.annotation.TargetApi
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebResourceRequest
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar


class WebViewer : Fragment() {

    private lateinit var wv: WebView
    private lateinit var editText: EditText
    private lateinit var btnGo: Button


    private class MyWebViewClient : WebViewClient() {
        @TargetApi(Build.VERSION_CODES.N)
        override fun shouldOverrideUrlLoading(view: WebView?, url: String): Boolean {
            view?.loadUrl(url)
            return true
        }
    }

  

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var v: View = inflater.inflate(R.layout.fragment_web_view, container, false)
        wv = v.findViewById(R.id.webView)
        wv.webViewClient = MyWebViewClient()
        editText = v.findViewById(R.id.webViewEditText)
        btnGo  = v.findViewById(R.id.webViewButton)
        wv.settings.javaScriptEnabled=true


        btnGo?.setOnClickListener {
            var link: String = editText.text.toString()
            if (link!=null && link.length>0){
                wv.loadUrl(link)
            }else{
                wv.loadUrl("google.com")
            }



        }

       return v
    }


}