package com.example.hansei

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper


class SplashActivity : BaseActivity() {
    var isTokenOk = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        setupEvents()
        setValues()

        //메인루퍼에게 명령을 내린다 //메인쓰레드와 통신을 한다!!
        val myHandler = Handler(Looper.getMainLooper())

        myHandler.postDelayed(
            {
                val myIntent = Intent(this, SignUpActivity::class.java) //영상화면 이후 본격 앱화면으로 넘겨주기
                startActivity(myIntent)
                finish()
            }, 2500//2.5초 뒤에 실행해주세요
        )


    }

    override fun setupEvents() {

    }

    override fun setValues() {

    }
}