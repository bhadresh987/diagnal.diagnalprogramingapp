package com.diagnal.diagnalprogramingapp.models

import com.google.gson.annotations.SerializedName

data class Page(
    @SerializedName("page")
    val page: PageX
)

data class PageX(
    @SerializedName("content-items")
    val contentItems: ContentItems,
    @SerializedName("page-num")
    val pageNum: String,
    @SerializedName("page-size")
    val pageSize: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("total-content-items")
    val totalContentItems: String
)

data class ContentItems(
    @SerializedName("content")
    val content: List<Content>
)

data class Content(
    @SerializedName("name")
    val name: String,
    @SerializedName("poster-image")
    val posterImage: String
)