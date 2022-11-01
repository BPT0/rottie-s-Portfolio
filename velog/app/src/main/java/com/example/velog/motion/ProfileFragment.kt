package com.classylab.classy_android.view.bottomnavigation

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.velog.R

class ProfileFragment:Fragment() {
    companion object{
        const val tag: String = "로그"
        fun newInstance() : ProfileFragment{
            return  ProfileFragment()
        }
    }

    // 메모리에 올라갔을때
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    // 프레그먼트를 안고 있는 액티비티에 붙었을때
    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    // 뷰가 생성되었을때
    // 프레그먼트와 레이아웃을 연결
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false).apply {
            // 비디오 리사이클러뷰 설정
            /*val videoList = arrayListOf(
                VideoModel(R.drawable.sample_video_sumnail, R.drawable.sample_videoowner, "Classy Dancer 페스티벌에 인플루언서로 초대받아 다녀왔어요!", 1603, "채널명", 19, 23, 1),
                VideoModel(R.drawable.sample_video_sumnail2, R.drawable.sample_videoowner, "영상제목", 1603, "채널명", 19, 23, 1),
                VideoModel(R.drawable.sample_video_sumnail3, R.drawable.sample_videoowner, "영상제목", 1603, "채널명", 19, 23, 1),
                VideoModel(R.drawable.sample_video_sumnail4, R.drawable.sample_videoowner, "영상제목", 1603, "채널명", 19, 23, 1),
                VideoModel(R.drawable.sample_video_sumnail5, R.drawable.sample_videoowner, "영상제목", 1603, "채널명", 19, 23, 1),
                VideoModel(R.drawable.sample_video_sumnail, R.drawable.sample_videoowner, "영상제목", 1603, "채널명", 19, 23, 1),
                VideoModel(R.drawable.sample_video_sumnail2, R.drawable.sample_videoowner, "영상제목", 1603, "채널명", 19, 23, 1),
                VideoModel(R.drawable.sample_video_sumnail3, R.drawable.sample_videoowner, "영상제목", 1603, "채널명", 19, 23, 1),
            )
            findViewById<RecyclerView>(R.id.rv_videoes).apply{
                layoutManager = LinearLayoutManager(view?.context, LinearLayoutManager.VERTICAL, false)
                setHasFixedSize(true)
                adapter = VideoAdapter(R.layout.item_video, this)
            }*/
        }
        return view
    }

}