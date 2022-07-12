package com.example.velog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat

class ResourceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resource)

        (findViewById<TextView>(R.id.text)).setOnClickListener {
            (it as TextView).text = resources.getText(R.string.app_name)
            // it.background = resources.getDrawable(R.drawble.eye) // deprecated 됨

            /*it.background = resources.getDrawable(R.drawable.eye, this.theme)
            it.background = ContextCompat.getDrawable(this, R.drawable.eye)
            it.background = ResourcesCompat.getDrawable(resources, R.drawable.eye, null)*/
        }

        (findViewById<ImageView>(R.id.image)).setOnClickListener {
            (it as ImageView).setImageDrawable(
                resources.getDrawable(R.drawable.eye, this.theme)
            )
        }
    }
}