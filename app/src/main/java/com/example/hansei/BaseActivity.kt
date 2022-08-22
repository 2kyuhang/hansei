package com.example.hansei

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


abstract class BaseActivity : AppCompatActivity() {

    lateinit var mContext : Context

    /*lateinit var retrofit: Retrofit
    lateinit var apiList : APIList*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mContext = this
        /*retrofit = ServerAPI.getRetrofit(mContext)
        apiList = retrofit.create(APIList::class.java)*/
    }

    abstract fun setupEvents()
    abstract fun setValues()
}