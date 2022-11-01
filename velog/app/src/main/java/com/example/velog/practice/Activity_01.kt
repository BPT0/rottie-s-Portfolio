package com.example.velog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class Activity_01 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState) // 사용자가 남긴 정보를 저장하고 재사용하기 위한 정보를 가지고 있음
        setContentView(R.layout.activity_test)
        Log.d("LifeCycle", "onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.d("LifeCycle", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("LifeCycle", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("LifeCycle", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("LifeCycle", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("LifeCycle", "onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("LifeCycle", "onRestart")
    }
}