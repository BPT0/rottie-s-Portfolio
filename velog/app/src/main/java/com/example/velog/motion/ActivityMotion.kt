package com.example.velog.motion

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.GestureDetector
import android.view.MenuItem
import android.view.MotionEvent
import android.widget.Toast
import com.classylab.classy_android.view.bottomnavigation.ProfileFragment
import com.example.velog.R
import com.example.velog.databinding.ActivityMotionBinding
import com.google.android.material.navigation.NavigationBarView

class ActivityMotion : AppCompatActivity(), NavigationBarView.OnItemSelectedListener{
    private var homeFragment: HomeFragment? = null
    private var profileFragment: ProfileFragment? = null
    private var waitTime = 0L

    // view binding 관련 변수
    private var _binding: ActivityMotionBinding? = null
    private val binding get() = _binding!!

    override fun onStart() {
        super.onStart()
        // bnv 롱클릭 툴팁 제거
        disableMenuTooltip()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMotionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_video_frame, PlayerFragment())
            .commit()


        // 바텀 네비게이션 설정
        initBotttomNavigation()

    }



    private fun disableMenuTooltip(){
        /*var home = findViewById(R.id.HOME) as View
        var light = findViewById(R.id.light) as View
        var heart = findViewById(R.id.heart) as View
        var posting = findViewById(R.id.posting) as View
        var profile = findViewById(R.id.profile) as View
        var longClickListener: View.OnLongClickListener = View.OnLongClickListener {
            return@OnLongClickListener true
        }
        home.setOnLongClickListener(longClickListener)
        light.setOnLongClickListener(longClickListener)
        heart.setOnLongClickListener(longClickListener)
        posting.setOnLongClickListener(longClickListener)
        profile.setOnLongClickListener(longClickListener)*/
    }

    private fun initBotttomNavigation(){
        // 첫번째 화면하고 탭 설정
        binding.apply {
            binding.bnv.setOnItemSelectedListener(this@ActivityMotion)
            homeFragment = HomeFragment.newInstance()
            supportFragmentManager.beginTransaction().replace(
                R.id.frgmentFrame, homeFragment!!).commit()
            binding.bnv.selectedItemId = R.id.frgmentFrame
        }
    }

    // 바텀네비게이션 리스너 설정
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.HOME ->{
                if(homeFragment==null){
                    homeFragment = HomeFragment.newInstance()
                    supportFragmentManager.beginTransaction().add(
                        R.id.frgmentFrame, homeFragment!!).commit()
                }
                if(homeFragment!=null)
                    supportFragmentManager.beginTransaction().show(homeFragment!!).commit()
                if(profileFragment!=null)
                    supportFragmentManager.beginTransaction().hide(profileFragment!!).commit()
            }
            R.id.profile->{
                if(profileFragment==null){
                    profileFragment = ProfileFragment.newInstance()
                    supportFragmentManager.beginTransaction().add(
                        R.id.frgmentFrame, profileFragment!!).commit()
                }
                if(profileFragment!=null)
                    supportFragmentManager.beginTransaction().show(profileFragment!!).commit()
                if(homeFragment!=null)
                    supportFragmentManager.beginTransaction().hide(homeFragment!!).commit()
            }
            else->{
                if(homeFragment==null){
                    homeFragment = HomeFragment.newInstance()
                    supportFragmentManager.beginTransaction().add(
                        R.id.frgmentFrame, homeFragment!!).commit()
                }
                if(homeFragment!=null)
                    supportFragmentManager.beginTransaction().show(homeFragment!!).commit()
                if(profileFragment!=null)
                    supportFragmentManager.beginTransaction().hide(profileFragment!!).commit()
            }
        }
        return true
    }

    override fun onBackPressed() {
        if(System.currentTimeMillis() - waitTime >=1500 ) {
            waitTime = System.currentTimeMillis()
            Toast.makeText(this,"뒤로가기 버튼을 한번 더 누르면 종료됩니다.", Toast.LENGTH_SHORT).show()
        } else {
            finish() // 액티비티 종료
        }
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}