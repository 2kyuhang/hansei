package com.example.hansei

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hansei.databinding.ActivityLoginBinding

class LoginActivity : BaseActivity() {

    lateinit var binding : ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    override fun setupEvents() {
        TODO("Not yet implemented")
    }

    override fun setValues() {
        TODO("Not yet implemented")
    }
}