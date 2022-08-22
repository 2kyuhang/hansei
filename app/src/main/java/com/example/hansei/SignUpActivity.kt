package com.example.hansei

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.hansei.databinding.ActivitySignUpBinding
import com.example.hansei.datas.BasicResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SignUpActivity : BaseActivity() {

    lateinit var binding: ActivitySignUpBinding
    var isEmailOk = true
    var isNickOk = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_up)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {
        binding.signUpBtn.setOnClickListener {
            val inputEmail = binding.emailEdt.text.toString()
            if (inputEmail.isBlank()) {
                Toast.makeText(mContext, "이메일을 입력해주세요.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val inputPw = binding.passwordEdt.text.toString()
            if (inputPw.isBlank()) {
                Toast.makeText(mContext, "비밀번호는 빈칸 혹은 공백일 수 없습니다.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val checkPw = binding.checkPwEdt.text.toString()
            if (inputPw != checkPw) {
                Toast.makeText(mContext, "비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val inputNick = binding.nickEdt.text.toString()
            if (inputNick.isBlank()) {
                Toast.makeText(mContext, "닉네임을 입력해주세요.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (!isEmailOk || !isNickOk) {
                Toast.makeText(mContext, "이메일 및 닉네임 중복 검사 진행해주세요.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            apiList.putRequestSignUp(
                inputEmail, inputPw, inputNick
            ).enqueue(object : Callback<BasicResponse> {
                override fun onResponse(
                    call: Call<BasicResponse>,
                    response: Response<BasicResponse>
                ) {
                    if(response.isSuccessful){
                        val br = response.body()!!
                        Toast.makeText(mContext, "가입을 축하합니다.", Toast.LENGTH_SHORT)
                        /*finish()*/
                    }else{
                        Toast.makeText(mContext, "가입 실패", Toast.LENGTH_SHORT)
                    }
                }

                override fun onFailure(call: Call<BasicResponse>, t: Throwable) {
                    Log.d("문제", t.toString())
                }
            })


        }
    }

    override fun setValues() {

    }



}