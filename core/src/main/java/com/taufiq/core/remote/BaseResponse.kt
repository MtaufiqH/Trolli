package com.taufiq.core.remote


import com.google.gson.annotations.SerializedName

data class BaseResponse<T>(
    @SerializedName("status")
    val status: Boolean? = false,
    @SerializedName("code")
    val code: Int? = 0,
    @SerializedName("message")
    val message: String? = "",
    @SerializedName("data")
    val `data`: T? = null
)