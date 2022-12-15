package com.ozancanguz.coronanews.data.model


import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("date")
    val date: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("source")
    val source: String,
    @SerializedName("url")
    val url: String
)