package com.example.velog.motion.video

import androidx.lifecycle.MutableLiveData
import com.example.velog.motion.video.VideoApiS
import retrofit2.Call
import retrofit2.Response

class  VideoRepo {
    // 1.비디오 목록 조회
    var videoList = MutableLiveData<VideoList>()
    fun getVideoList(page: Int, size: Int) {
        val call = VideoApiS.ClassyVideoClient.createApi()
            .getVideoList(page.toString(), size.toString())
        call.enqueue(object : retrofit2.Callback<VideoList> {
            override fun onResponse(
                call: Call<VideoList>,
                response: Response<VideoList>)
            {
                // 응답 잘 받은 경우
                if (response.isSuccessful) videoList.value = response.body()!!
                else{}// 통신 성공, 응답 문제 발생
            }
            // 통신 실패한 경우
            override fun onFailure(call: Call<VideoList>, t: Throwable) {}
        })
    }

    // 비디오 조회 -> 영상 불러옴
    var video = MutableLiveData<Video>()
    fun getVideo(videoId: Int){
        val call = VideoApiS.ClassyVideoClient.createApi().getVideo(videoId)
        call.enqueue(object : retrofit2.Callback<Video>{
            override fun onResponse(call: Call<Video>, response: Response<Video>) {
                if (response.isSuccessful) video.value = response.body()!!
                else{}
            }
            override fun onFailure(call: Call<Video>, t: Throwable) {}
        })
    }
}

// 모든 비디오 조회
// 페이지 번호 0번부터 시작 (1씩 증가 시켜서 요청을 한다)
// 페이지 크기 10
// 없는 데이터는 프론트 데이터 사용
// 정렬사용 예시
    // uploadDateTime,ASC
    // videoId,ASC

// 비디오 리스폰스스(리스트) 안에 비디오 리스폰스 객체를 가져온다