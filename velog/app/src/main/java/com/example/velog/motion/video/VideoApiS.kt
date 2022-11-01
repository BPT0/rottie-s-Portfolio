package com.example.velog.motion.video

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface VideoApiS {
    @GET("v1/all-videos")
    fun getVideoList(
        @Query("page") page: String,
        @Query("size") size: String
    ): Call<VideoList>

    @GET("v1/video")
    fun getVideo(
        @Query("videoId") videoId: Int
    ):Call<Video>

    object ClassyVideoClient {
        private val baseUrl = "http://54.180.200.4:8080/" // 베이스 URL

        private val retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create()) //GsonConverter 이용하겠다는 의미
                .build()


        fun createApi(): VideoApiS {
            return retrofit.create(VideoApiS::class.java)
        }
    }
}


