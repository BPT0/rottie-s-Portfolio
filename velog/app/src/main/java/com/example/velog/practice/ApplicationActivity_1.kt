package com.example.velog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class ApplicationActivity_1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_application1)

        (findViewById<TextView>(R.id.changeActivity)).setOnClickListener {
            startActivity(
                Intent(this, ApplicationActivity_2::class.java)
            )
        }

        (findViewById<TextView>(R.id.testMethod)).setOnClickListener {
            (applicationContext as MasterApplication).methosFromApplication()
            val userId = (applicationContext as MasterApplication).userId
            Log.d("testt", "user id is"+userId)
        }
    }
}