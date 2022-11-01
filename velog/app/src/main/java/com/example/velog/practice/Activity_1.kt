package com.example.velog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Activity_1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_1)

        (findViewById<TextView>(R.id.one)).setOnClickListener {
            startActivity(Intent(this@Activity_1, Activity_1::class.java))
        }
        (findViewById<TextView>(R.id.two)).setOnClickListener {
            startActivity(Intent(this@Activity_1, Activity_2::class.java))
        }
        (findViewById<TextView>(R.id.three)).setOnClickListener {
            startActivity(Intent(this@Activity_1, Activity_3::class.java))
        }
        /*
        * singleTop - top에 있지 않은 경우엔 쌓인다(standard 와 동일)
        * singleTask - singleTask-activity가 쌓이면 해당 스택만 담은 박스가 생성
        */
    }
}