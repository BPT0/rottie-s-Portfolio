package com.example.velog.motion.video

import com.google.gson.annotations.SerializedName
import java.util.*

data class VideoList(
    @SerializedName("videoResponses")
    val videoResponses: ArrayList<Video>
)

data class Video(
    @SerializedName("videoId")
    val videoId: Int, // db에서 데이터 가져올때 식별하는 고유id

    @SerializedName("title")
    val title: String,

    @SerializedName("nickname")
    val nickname: String,

    @SerializedName("videoUrl")
    val videoUrl: String,

    val videoLunningTime : String,

    @SerializedName("thumbnailUrl")
    val thumbnailUrl: String,

    // String 형태로 전달 받기 가능
    val ownerUrl: Int,

    @SerializedName("uploadDateTime")
    val uploadDateTime: String,

    @SerializedName("views")
    val views: Int
)


