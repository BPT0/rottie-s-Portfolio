package com.example.velog

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContract
import org.w3c.dom.Text

class Intent_one : AppCompatActivity() {
    val INTENT_TWO  = 1
    private lateinit var getResult : ActivityResultLauncher<Intent>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_one)

        /* 암시적 인텐트
            -상수
                - 변하지 않는 수 (문자)
                - 상수의 변수명은 전부 대문자로 만드는 문화가 있다
            -URI (Uniform Resource Indentifier)
                - id라고 생각을 하면 된다 -> 고유하다
                - 자원을 나타낸느 주소
                - URL
                    - 인터넷 페이지의 고유한 주소

        */
        val implict_intent: TextView = findViewById(R.id.tv1)
        implict_intent.setOnClickListener {
            val intent: Intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+"010-1111-1111"))
            val intent2: Intent = Intent(Intent.ACTION_PICK)

            startActivity(intent)
        }

        // 명시적 인텐트 -> 액티비티 전환
        // Context
        // - 문맥
        // A액티비티 -> B액티비티
        (findViewById<TextView>(R.id.tv2)).apply{
            this.setOnClickListener{
                startActivity(
                    Intent(this@Intent_one, Intent_two::class.java)
                )
            }
        }

        // 명시적 인텐트 + data 전달
        (findViewById<TextView>(R.id.tv3)).apply{
            this.setOnClickListener{
                val intent = Intent(this@Intent_one, Intent_two::class.java)
                intent.putExtra("extra-data", "data-one")
                startActivity(intent)

            }
        }

        // 명시적 인텐트 + 결과 받기
        // requestCode
        // - 구분을 하기 위해서
        // - Intent_One -> Intent_Two (request 1)
        // - Intent_One -> Intent_Three (request 2)
        // - Intent_One -> Intent_Four (request 3)

        (findViewById<TextView>(R.id.tv4)).apply{
            this.setOnClickListener{
                val intent = Intent(this@Intent_one, Intent_two::class.java)
                startActivityForResult(intent, INTENT_TWO) // deprecated 되었다
            }
        }

        /*(findViewById<TextView>(R.id.tv5)).apply{
            this.setOnClickListener{
                val intent = Intent(this@Intent_one, Intent_two::class.java)
                startActivityLauncher.launch(intent)
            }
        }

        // 명시적 인텐트 + 결과받기 (ActivityResult API)
        // -> requstCOde 없이도 요청자를 구별할 수 있음
        getResult = registerForActivityResult(ActivityResultContract.StartActivityForResult()){
            // onActivityResult에 해당하는 부분
                when(it.resultcode){
                    RESULT_OK ->{
                        Log.d("data", it.data?.extras?.getString("result")!!)
                    }
                }
                // onActivityResult
                // - 모든 intent가 한 곳에서 처리된다 -> 구분이 필요하다(request code)
                // ActivityResult API
                // - 각각의 intent가 처리되는 곳이 별도로 있다 -> 구분이 필요없다
            }*/

        (findViewById<TextView>(R.id.tv6)).apply{
            this.setOnClickListener{
                val intent = Intent(this@Intent_one, Intent_two::class.java).apply {
                    val imageUri = Uri.parse("android.resource://" + packageName + "/drawable/" + "eye")
                    this.action = Intent.ACTION_SEND
                    this.putExtra(Intent.EXTRA_STREAM, imageUri)
                    this.setType("image/*")
                }
                startActivityForResult(intent, INTENT_TWO) // deprecated 되었다
            }
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        // resultCode (status code)
        // - 최종 결과
        // - 성공, 실패
        when(requestCode){
            INTENT_TWO->{
                when(resultCode){
                    RESULT_OK ->{
                        val data: String? = data?.extras?.getString("result")
                        Log.d("data", data!!)
                    }
                }
            }

        }
    }


}