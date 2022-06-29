package com.example.velog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView

class ViewControl_02 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_control02)

        // 뷰를 코틀린 파일(Activity)로 가져오는 방법
        val tv_1 : TextView = findViewById(R.id.textView_1)
        val btn_1 : Button = findViewById(R.id.btn1)
        Log.d("test1", tv_1.text.toString())

        // Listener 사용방법
        btn_1.setOnClickListener{
            // 버튼이 클릭되었을때 동작할 코드
            Log.d("test1", btn_1.text.toString())
        }

        val clickListener = object : View.OnClickListener{
            override fun onClick(p0: View?) {

            }
        }
        btn_1.setOnClickListener(clickListener)

        btn_1.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
            }
        })

    }
}