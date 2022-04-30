package com.taufiq.profile.data.remote.response


import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class UserResponse(
    @SerializedName("id")
    val id: String? = "",
    @SerializedName("username")
    val username: String? = "",
    @SerializedName("role")
    val role: String? = "",
    @SerializedName("image_url")
    val imageUrl: String? = "",
    @SerializedName("full_name")
    val fullName: String? = "",
    @SerializedName("city")
    val city: String? = "",
    @SerializedName("simple_address")
    val simpleAddress: String? = ""
)