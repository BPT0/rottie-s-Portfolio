package com.example.velog

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class ShareedPreferenceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shareed_preference)


        // SharedPreference 사용법
        findViewById<TextView>(R.id.create).setOnClickListener {
            //Create
            val sharedPreferences = getSharedPreferences("table_name", Context.MODE_MULTI_PROCESS)
            // MODE
            // MODE_PRIVATE -> 현재 앱에서만 사용을 하겠다 -> 다른 앱과 공유하지 않겠다 (대부분 이방식 사용)
            // MODE_APPEND: 기존 preference에 신규로 추가
            // 아래 3개는 데프리케이티드됨
            // MODE_WORLD_READABLE : 다른 앱에서도 사용가능 (읽기만 가능)
            // MODE_WORLD_WRITEABLE: 다른 앱에서도 사용가능 (읽기, 쓰기 가능)
            // MODE_MULTI_PROCESS: 이미 호출되어 사용중인지 체크
            val editor: SharedPreferences.Editor = sharedPreferences.edit()
            editor.putString("key1", "hello1") // key-value 방식으로 데이터를 저장
            editor.putString("key2", "hello2") // key-value 방식으로 데이터를 저장
            editor.commit()
        }

        findViewById<TextView>(R.id.read).setOnClickListener{
            val sharedPreferences = getSharedPreferences("table_name", Context.MODE_PRIVATE)
            val valueOne = sharedPreferences.getString("key1", "Wrong1")
            val valueTwo = sharedPreferences.getString("key2", "Wrong2")
            Log.d("testt", valueOne!!)
            Log.d("testt", valueTwo!!)

        }

        findViewById<TextView>(R.id.update).setOnClickListener{
            val sharedPreferences = getSharedPreferences("table_name", Context.MODE_PRIVATE)
            val editor: SharedPreferences.Editor = sharedPreferences.edit()
            editor.putString("key1", "hello hello") // 기존에사용했던 키와 동일한 키를 사용해서 데이터를 저장 -> Update
            editor.commit()
        }

        findViewById<TextView>(R.id.delete).setOnClickListener{
            val sharedPreferences = getSharedPreferences("table_name", Context.MODE_PRIVATE)
            val editor: SharedPreferences.Editor = sharedPreferences.edit()
            editor.clear() // table_name 으로 된 테이블의 데이터를 삭제
            editor.commit()
        }

    }
}