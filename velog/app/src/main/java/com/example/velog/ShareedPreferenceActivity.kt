package com.example.velog

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ShareedPreferenceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shareed_preference)

        // SharedPreference 사용법
        findViewById<TextView>(R.id.create).setOnClickListener{
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
            editor.putString("key", "hello")
            editor.commit()


        }
    }
}