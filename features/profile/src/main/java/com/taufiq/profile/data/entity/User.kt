package com.taufiq.profile.data.entity

import com.google.gson.annotations.SerializedName

data class User(
    val id: String = "",
    val username: String = "",
    val role: String = "",
    val imageUrl: String = "",
    val fullName: String = "",
    val city: String = "",
    val simpleAddress: String = ""
)