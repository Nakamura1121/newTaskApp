package com.sample.servicetaskapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var infoTextView : TextView
    private lateinit var notificationServiceBtn : Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        infoTextView = findViewById(R.id.info_text)
        notificationServiceBtn = findViewById(R.id.start_service_btn)
        val serviceIntent = Intent(this, NotificationService::class.java)
        val stopService = intent.getBooleanExtra("stop_service", false)
        if (stopService) {
            stopService(serviceIntent)
            infoTextView.text = "Notification Service Stopped"
        }

        notificationServiceBtn.setOnClickListener {
            infoTextView.text = "Notification Service Started"
            startService(serviceIntent)
        }

    }
}



