package com.example.hansei.api

import com.example.hansei.datas.BasicResponse
import retrofit2.Call
import retrofit2.http.*

interface APIList {
    //회원가입
    @FormUrlEncoded //폼데이터라서
    @PUT("/user")
    fun putRequestSignUp(
        @Field("email") email: String,
        @Field("password") pw: String,
        @Field("nick_name") nick: String
    ): Call<BasicResponse>

    //이메일 닉네임 중복 체크
    @GET("/user/check")
    fun getRequestDupCheck(
        @Query("type") type: String,
        @Query("value") value: String
    ): Call<BasicResponse>

    //로그인
    @FormUrlEncoded //폼데이터라서
    @POST("/user")
    fun postRequestLogin(
        @Field("email") email: String,
        @Field("password") password: String
    ): Call<BasicResponse>


}