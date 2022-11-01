package com.example.velog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.Glide

class GlideActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_glide)

        var imageView =  findViewById<ImageView>(R.id.image)

        Glide
            .with(this)
            .load("https://t1.daumcdn.net/cfile/tistory/2076963B50435E2A32")
            .fitCenter()
            .into(imageView)
    }
}