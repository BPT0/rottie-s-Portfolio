package com.example.velog

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class Fragment_1 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // inflater : XML을 화면에 사용할 준비를 한다 (xml -> View로 만들어 준다)
        // container : 프라그먼트에서 사용될 XML의 부모 뷰
        val view = inflater.inflate(R.layout.fragment_1, container, false)
        // attachToRoot : 루트뷰에 언제 붙일지에 관련된 인자

        // View를 만드는 과정에서 리스너를 다는 과정을 담음음
        (view.findViewById<TextView>(R.id.call_activity)).setOnClickListener {
            (activity as FragmentActivity).printTestLog()
        }

        return view
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val data : String? = arguments?.getString("key")
        Log.e("test1", "data is " + data)
    }

    fun printTestLog(){
        Log.e("test2", "print test log from fragment")
    }
}
