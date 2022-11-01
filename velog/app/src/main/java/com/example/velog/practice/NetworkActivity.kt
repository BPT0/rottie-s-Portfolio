package com.example.velog

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.loader.content.AsyncTaskLoader
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

// NetworkOnMainThreadException
// - 메인 쓰레드에는 화면작업만 하라는 에러
// - 쓰레드를 개별적으로 만들어서 진행해야됨


class NetworkActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_network)

        NetworkAsyncTask().execute()
    }
}

class NetworkAsyncTask(): AsyncTask<Any?, Any?, Any?>(){
    override fun doInBackground(vararg params: Any?): Any? {
        val urlString: String = "http://mellowcode.org/json/students/"
        val url : URL = URL(urlString)
        val connection : HttpURLConnection = url.openConnection() as HttpURLConnection

        connection.requestMethod = "GET"
        connection.setRequestProperty("Content-Type", "application/json")

        var buffer = ""
        if(connection.responseCode == HttpURLConnection.HTTP_OK){
            val reader = BufferedReader(
                InputStreamReader(
                    connection.inputStream,
                    "UTF-8"
                )
            )
            buffer = reader.readLine()
            Log.d("testt", buffer)
        }
        return null
    }
}