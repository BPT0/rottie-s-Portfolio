package com.example.velog.motion

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.velog.motion.video.Video
import com.example.velog.motion.video.VideoList
import com.example.velog.motion.video.VideoRepo

class VideoViewModel: ViewModel() {
    private val videoRepository = VideoRepo()
    private val videoList: LiveData<VideoList> = videoRepository.videoList
    private val video: LiveData<Video> = videoRepository.video

    fun loadVideoList(page: Int, size: Int){
        videoRepository.getVideoList(page, size)
    }

    fun getAllVideos(): LiveData<VideoList> {
        return videoList
    }

    fun loadVideo(videoId: Int){
        videoRepository.getVideo(videoId)
    }

    fun getVideo(): LiveData<Video>{
        return video
    }
}