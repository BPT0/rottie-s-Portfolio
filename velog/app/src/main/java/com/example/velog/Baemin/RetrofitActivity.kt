package com.example.velog.Baemin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.velog.databinding.ActivityMainBinding

class RetrofitActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var noticeAdapter: NoticeAdapter
    private val baeminRepository = BaeminRepository()
    private var page = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvBaeminNotice.apply {
            binding.rvBaeminNotice.layoutManager = LinearLayoutManager(context)
            noticeAdapter = NoticeAdapter()
            binding.rvBaeminNotice.adapter = noticeAdapter
        }

        baeminRepository.loadBaeminNotice(page, this) // 첫 페이지

        binding.btnLoadNextPage.setOnClickListener {// 버튼을 누를 때 마다
            baeminRepository.loadBaeminNotice(++page, this) // 다음 페이지를 로드한다.
        }

        binding.btnLoadUndoPage.setOnClickListener {// 버튼을 누를 때 마다
            // 이전페이지가 있다면
            if(page>1){
                baeminRepository.loadBaeminNotice(--page, this) // 이전 페이지를 로드한다.
            }else{
                Toast.makeText(this, "첫 번째 페이지 입니다", Toast.LENGTH_SHORT).show()
            }
        }  
    }

    // 성공적으로 로드한 경우
    fun loadComplete(data: Data) {
        noticeAdapter.setList(data.content)
        noticeAdapter.notifyDataSetChanged()
    }

    // 응답에 문제가 있는 경우
    fun responseIsNotSuccesful(code: Int) {
        Toast.makeText(this, "사이트가 응답하지 않습니다", Toast.LENGTH_SHORT).show()
        Log.v("로그", code.toString())
    }

    // 로드에 실패한 경우
    fun loadFail() {
        Toast.makeText(this, "인터넷 연결을 확인하세요", Toast.LENGTH_SHORT).show()
    }
   /* override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit)


        // 서버 -> 읽을수 없는 데이터 -> JSON ->
        // GSON -> 읽을 수 없는 데이터를 코틀린 객체로 바꿔준다
        val retrofit = Retrofit.Builder()
            .baseUrl("http://mellowcode.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val retrofitService = retrofit.create(RetrofitService::class.java)
        retrofitService!!.getStrudentList().enqueue(object : Callback<ArrayList<StudentFromServer>>{
            override fun onResponse(
                call: Call<ArrayList<StudentFromServer>>,
                response: Response<ArrayList<StudentFromServer>>
            ) {
                if (response.isSuccessful){
                    val studentList = response.body()
                    studentList?.forEach {
                        Log.d("testy", ""+it.name)
                    }
                }else{
                    Log.d("testn", "404 not found")
                }
            }

            override fun onFailure(call: Call<ArrayList<StudentFromServer>>, t: Throwable) {
                Log.d("testn", "connect fail")
            }
        })

    }*/
}