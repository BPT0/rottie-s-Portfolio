package com.example.velog.Baemin

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BaeminRepository {
    fun loadBaeminNotice(page: Int, mCallback: RetrofitActivity) {
        val call = BaeminClient.service.loadNotice(page.toString())

        call.enqueue(object : Callback<Baemin> {
            override fun onResponse(
                call: Call<Baemin>,
                response: Response<Baemin>
            ) {
                if(response.isSuccessful){
                    mCallback.loadComplete(response.body()!!.data)
                } else {
                    mCallback.responseIsNotSuccesful(response.code())
                }
            }

            override fun onFailure(call: Call<Baemin>, t: Throwable) {
                mCallback.loadFail()
            }
        })
    }
}