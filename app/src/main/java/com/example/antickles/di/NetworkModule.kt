package com.example.antickles.di

import com.example.antickles.mediumApi.MediumApi
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import okhttp3.ResponseBody.Companion.toResponseBody
import retrofit2.Response
import retrofit2.Retrofit

interface NetworkModule {

    val mediumApi: MediumApi

}

@OptIn(ExperimentalSerializationApi::class)
fun networkModule() = object : NetworkModule {

    val contentType = "application/json".toMediaType()

    val okHttpClient = OkHttpClient.Builder().
            addInterceptor {
                //val response = it.proceed(it.request())
                val mimeType = "application/json";
                Response.success(json.toByteArray().toResponseBody(mimeType.toMediaTypeOrNull())
            }.build()


    val retrofit: Retrofit = Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl("https://api.medium.com")
        .addConverterFactory(Json.asConverterFactory(contentType))
        .build()

    override val mediumApi: MediumApi = retrofit.create(MediumApi::class.java)
}

val json = """
   {
  "articles": [
    {
      "title": "Configuration Caching deep dive",
      "description": "What is configuration caching?",
      "type": "article",
      "image": "https://miro.medium.com/v2/resize:fit:1200/1*E0g4dU6DuLRp5wzblvr5yg.png",
      "url": "https://medium.com/androiddevelopers/configuration-caching-deep-dive-bcb304698070",
      "favicon": "https://miro.medium.com/v2/1*m-R_BkNf1Qjr1YbyOIJY2w.png",
      "site_name": "Medium",
      "articlePublishedTime": "2020-10-15T17:29:58.057Z",
      "articleAuthor": "https://medium.com/@gavra01"
    }
  ]
}
""".trimIndent()
