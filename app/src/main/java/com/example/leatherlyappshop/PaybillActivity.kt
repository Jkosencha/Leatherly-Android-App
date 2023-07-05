package com.example.leatherlyappshop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class PaybillActivity : AppCompatActivity() {

    lateinit var paybtn : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_paybill)

        paybtn = findViewById(R.id.paybtn)

        paybtn.setOnClickListener {
            val simToolKitLaunchIntent = applicationContext.packageManager.getLaunchIntentForPackage("com.android.stk")
            simToolKitLaunchIntent?.let { startActivity(it) }
        }
    }
}