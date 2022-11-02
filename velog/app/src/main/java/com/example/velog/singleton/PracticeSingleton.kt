package com.example.velog.singleton

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.velog.databinding.ActivityMotionBinding

class PracticeSingleton(): AppCompatActivity(){

    val TAG: String = "로그"

    // view binding 관련 변수
    private var _binding: ActivityMotionBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMotionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.d(TAG, "MainActivity - onCreate() called")

        val singletonClass_1 = SingletonClass
        val singletonClass_2 = SingletonClass

        Log.d(TAG, "MainActivity - onCreate() called : $singletonClass_1")
        Log.d(TAG, "MainActivity - onCreate() called : $singletonClass_2")

        // 매개 변수를 가진 싱글턴?
        val mySQLOpenHelperSingleton_1 = MySQLOpenHelperSingleton.getInstance(this)
        val mySQLOpenHelperSingleton_2 = MySQLOpenHelperSingleton.getInstance(this)

        Log.d(TAG, "MainActivity - onCreate() called : $mySQLOpenHelperSingleton_1")
        Log.d(TAG, "MainActivity - onCreate() called : $mySQLOpenHelperSingleton_2")
    }

}