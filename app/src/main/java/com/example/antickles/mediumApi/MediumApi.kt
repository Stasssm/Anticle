package com.example.antickles.mediumApi

import com.example.antickles.mediumApi.models.UserData
import retrofit2.http.GET
import retrofit2.http.Header

interface MediumApi {

    @GET("/v1/me")
    suspend fun getUserInfo(
        @Header("Authorization") authorization: String = "Bearer 23f3df08d575d326e33cbe668aadb084d2d91aaa1c19370eae6d1d1d5fa5737eb",
        @Header("Content-Type") contentType: String = "application/json",
        @Header("Accept") accept: String = "application/json",
        @Header("Accept-Charset") acceptCharset: String = "utf-8",
    ) : UserData
}