package com.example.velog.Tinder

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.example.velog.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.text_input_layout.*

class LoginActivity : AppCompatActivity(){

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tinder_activity_login)

        auth = Firebase.auth

        val etx_email = findViewById<EditText>(R.id.etx_email)
        val etx_pw = findViewById<EditText>(R.id.etx_pw)

        initLoginButton()
        initSignupButton()
        initEmailAndPasswordEditText()
    }

    private fun initLoginButton() {
        val btn_login = findViewById<Button>(R.id.btn_login).setOnClickListener {
            val email = getInputEmail()
            val pw = getInputPw()

            auth.signInWithEmailAndPassword(email, pw)
                .addOnCompleteListener(this) { task ->
                    if(task.isSuccessful){

                        finish()
                    }else{
                        Toast.makeText(this, "로그인 실패, 이메일 또는 비밀번호 확인하세요", Toast.LENGTH_SHORT).show()
                    }
                }
        }
    }

    private fun initSignupButton() {
        val btn_signup = findViewById<Button>(R.id.btn_signup).setOnClickListener {
            val email = getInputEmail()
            val pw = getInputPw()

            auth.createUserWithEmailAndPassword(email, pw)
                .addOnCompleteListener(this) {task ->
                    if(task.isSuccessful){
                        Toast.makeText(this, "회원가입에 성공, 로그인 버튼을 눌러 로그인 해주세요", Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(this, "이미 가입한 이메일이거나, 회원가입에 실패했습니다.", Toast.LENGTH_SHORT).show()
                    }
                }
        }
    }

    private fun getInputEmail(): String {
        return findViewById<EditText>(R.id.etx_email).text.toString()
    }

    private fun getInputPw(): String {
        return findViewById<EditText>(R.id.etx_pw).text.toString()
    }

    private fun initEmailAndPasswordEditText(){
        val etx_email = findViewById<EditText>(R.id.etx_email)
        val etx_pw = findViewById<EditText>(R.id.etx_pw)
        val btn_login = findViewById<Button>(R.id.btn_login)
        val btn_signup = findViewById<Button>(R.id.btn_signup)

        etx_email.addTextChangedListener {
            val enable = etx_email.text.isNotEmpty() && etx_pw.text.isNotEmpty()
            btn_login.isEnabled = enable
            btn_signup.isEnabled = enable
        }

        etx_pw.addTextChangedListener{
            val enable = etx_email.text.isNotEmpty() && etx_pw.text.isNotEmpty()
            btn_login.isEnabled = enable
            btn_signup.isEnabled = enable
        }

    }


}