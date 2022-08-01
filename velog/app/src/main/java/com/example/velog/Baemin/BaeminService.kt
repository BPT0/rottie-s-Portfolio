package com.example.velog.Baemin

import retrofit2.Call
import retrofit2.http.*

class StudentFromServer(
    val id: Int, val name: String,
    val age: Int, val intro: String
)

interface RetrofitService {
    @GET("json/students")
    fun getStrudentList() : Call<ArrayList<StudentFromServer>>
}

interface BaeminService {
    @GET("contents?typeCode=notice&size=10")
    fun loadNotice(@Query("page") page: String): Call<Baemin>
}
