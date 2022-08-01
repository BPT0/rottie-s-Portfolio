package com.example.velog.Baemin

interface CompletionListener {
    fun loadComplete(data: Data)
    fun responseIsNotSuccesful(code: Int)
    fun loadFail()
}