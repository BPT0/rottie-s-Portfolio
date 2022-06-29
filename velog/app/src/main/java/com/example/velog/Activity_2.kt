package com.example.velog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Activity_2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)

        (findViewById<TextView>(R.id.one)).setOnClickListener {
            startActivity(Intent(this@Activity_2, Activity_1::class.java))
        }
        (findViewById<TextView>(R.id.two)).setOnClickListener {
            startActivity(Intent(this@Activity_2, Activity_2::class.java))
        }
        (findViewById<TextView>(R.id.three)).setOnClickListener {
            startActivity(Intent(this@Activity_2, Activity_3::class.java))
        }
    }
}