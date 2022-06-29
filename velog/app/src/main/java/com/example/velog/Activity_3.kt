package com.example.velog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Activity_3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_3)

        (findViewById<TextView>(R.id.one)).setOnClickListener {
            val intent= Intent(this@Activity_3, Activity_1::class.java)
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
        }
        (findViewById<TextView>(R.id.two)).setOnClickListener {
            startActivity(Intent(this@Activity_3, Activity_2::class.java))
        }
        (findViewById<TextView>(R.id.three)).setOnClickListener {
            startActivity(Intent(this@Activity_3, Activity_3::class.java))
        }
    }
}