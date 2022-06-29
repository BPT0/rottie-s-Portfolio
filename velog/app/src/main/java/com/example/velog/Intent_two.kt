package com.example.velog

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import android.widget.ImageView
import android.widget.TextView

class Intent_two : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_two)

        // Intent_One -> Intent_Two
        // Intent_Two 액티비티를 호출한 액티비티의 intent이다
        val intent = intent
        val data : String? = intent.extras?.getString("extra_data")

        if(data != null){
            Log.d("data", data)
        }

        // result 전달
        (findViewById<TextView>(R.id.finish)).apply{
            this.setOnClickListener{
                val intent: Intent = Intent()
                intent.putExtra("result", "success")
                setResult(RESULT_OK, intent)
                // Intent_One -> Intent_Two 로 갈때 종료
                finish()
            }
        }

        val image_view = findViewById<ImageView>(R.id.image_view)
        val uri = Uri.parse(
            intent.getParcelableExtra<Parcelable>(Intent.EXTRA_STREAM).toString()
        )
        image_view.setImageURI(uri)

    }


}