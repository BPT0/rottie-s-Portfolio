package com.example.velog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class TablayoutPagerSimpleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tablayout_pager_simple)

        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        val viewPager = findViewById<ViewPager>(R.id.viewPager)

        // 탭레이아웃에 탭을 추가
        tabLayout.addTab(tabLayout.newTab().setText("1번째"))
        tabLayout.addTab(tabLayout.newTab().setText("2번째"))
        tabLayout.addTab(tabLayout.newTab().setText("3번째"))

        // Pager에 adapter를 장착
        viewPager.adapter = viewPagerAdapter(LayoutInflater.from(this), 3)

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                viewPager.setCurrentItem(tab!!.position)
            }
            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })

        // 페이저 움직였을때 탭도 같이 움직이게 하는 역활
        // 페이저가 바뀌면 콜백되는 리스너, 페이저가 변경 되었을때 tab_layout을 호출해서
        // 지금 페이저가 바뀌었으니 tab도 바꾸라고 명령령
       viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))
    }
}

class viewPagerAdapter(
    val layoutInflater: LayoutInflater,
    var tabCount:Int
):PagerAdapter(){
    override fun getCount(): Int {
        return tabCount
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object` as View
        // == : 값을 비교
        // === : 주소값을 비교
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        when(position){
            0->{
                val view = layoutInflater.inflate(R.layout.fragment_1, container, false)
                container.addView(view)
                return view
            }
            1->{
                val view = layoutInflater.inflate(R.layout.fragment_1, container, false)
                container.addView(view)
                return view
            }
            else->{
                val view = layoutInflater.inflate(R.layout.fragment_1, container, false)
                container.addView(view)
                return view
            }
        }
    }
}