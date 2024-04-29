package com.example.antickles.mediumApi.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class ArticleList(
    @SerialName("")
    val list: List<Article>
)

@Serializable
class Article(
    @SerialName("title")
    val title: String,
    @SerialName("description")
    val description: String,
    @SerialName("type")
    val type: String,
    @SerialName("image")
    val image: String,
    @SerialName("url")
    val url: String,
    @SerialName("favicon")
    val favicon: String,
    @SerialName("site_name")
    val site_name: String,
    @SerialName("articlePublishedTime")
    val articlePublishedTime: String,
    @SerialName("articleAuthor")
    val articleAuthor: String,
)


