package com.example.velog.motion
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.velog.R
import com.example.velog.databinding.FragmentMainBinding

class HomeFragment: BaseFragment<FragmentMainBinding>(FragmentMainBinding::inflate) {
    companion object{
        const val tag: String = "로그"
        fun newInstance() : HomeFragment{
            return HomeFragment()
        }
    }

    // 비디오 리싸이클러뷰 설정
    private var page = 0
    private var size = 10
    private lateinit var videoAdapter: VideoAdapter
    private lateinit var model: VideoViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // 비디오 Recycler view init
        initRvVideoList()

        // 최하단에서 스크롤감지, content 업로드
        initScrollListener()
    }


    private fun initRvVideoList(){
        model = ViewModelProvider(this).get(VideoViewModel::class.java)
        model.loadVideoList(page, size)


        val adapterSpinner = ArrayAdapter.createFromResource(
            requireContext(),
            android.R.array.emailAddressTypes,
            R.layout.dropdown_menu_popup_item
        )

        binding.filledExposedDropdown.setAdapter(adapterSpinner)

        binding.rvVideo.apply{
            layoutManager = LinearLayoutManager(view?.context, LinearLayoutManager.VERTICAL, false)
            videoAdapter = VideoAdapter()
            adapter = videoAdapter
            adapter?.notifyDataSetChanged()
        }

        model.getAllVideos().observe(this@HomeFragment.viewLifecycleOwner , Observer {
            if(it.videoResponses!= null) {
                if (it.videoResponses.isNotEmpty()) {
                    if (it.videoResponses.size >= size) {
                        Log.d("통신", it.videoResponses.toString())
                        videoAdapter.setList(it.videoResponses)
                        videoAdapter.notifyItemRangeInserted((page) * size, size)
                        size-=5
                        page+=1
                    } else if (it.videoResponses.size <= size) {
                        Log.d("통신", it.videoResponses.toString())
                        videoAdapter.setList(it.videoResponses)
                        videoAdapter.notifyItemRangeInserted(
                            (page) * size,
                            it.videoResponses.size
                        )
                    }
                }else{
                    Log.d("통신", it.videoResponses.toString())
                }
            }
        })
    }

    private fun initScrollListener(){
        binding.stickyScrollView.setOnScrollChangeListener(object : View.OnScrollChangeListener{
            override fun onScrollChange(v: View?, scrollX: Int, scrollY: Int, oldScrollX: Int,
                oldScrollY: Int
            ) {
                if ((!v!!.canScrollVertically(1))) {
                    Toast.makeText(this@HomeFragment.context, "스크롤의 최하단입니다.", Toast.LENGTH_SHORT)
                        .show()
                    model.loadVideoList(++page, size)
                    videoAdapter.deleteLoading(videoes = model.getAllVideos().value!!.videoResponses!!)
                }
            }
        })

    }


}