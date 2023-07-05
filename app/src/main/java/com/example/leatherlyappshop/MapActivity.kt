package com.example.leatherlyappshop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button

class MapActivity : AppCompatActivity() {
    lateinit var web:WebView
    lateinit var location:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)

        web=findViewById(R.id.map)
        location=findViewById(R.id.backbtn)

        web.webViewClient= WebViewClient()
        web.loadUrl("https://www.google.com/maps/place/Kipro+Center+Dental+Clinic/@-1.2648706,36.7979926,17z/data=!3m1!4b1!4m6!3m5!1s0x182f1791a3266197:0x1b878049a1937f81!8m2!3d-1.2648706!4d36.8005675!16s%2Fg%2F11lgsftx2b?entry=ttu")
        web.settings.javaScriptEnabled=true
        web.settings.setSupportZoom(true)


        location.setOnClickListener {
            val intent=Intent(this,CategoryActivity::class.java)
            startActivity(intent)
        }

    }
}