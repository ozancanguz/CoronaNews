package com.ozancanguz.coronanews.data.model


import com.google.gson.annotations.SerializedName

data class CoronaNews(
    @SerializedName("result")
    val result: List<Result>,

)