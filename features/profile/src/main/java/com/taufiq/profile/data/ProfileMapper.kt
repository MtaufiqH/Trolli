package com.taufiq.profile.data

import com.taufiq.profile.data.entity.User
import com.taufiq.profile.data.remote.response.UserResponse

object ProfileMapper {

    fun UserResponse.responseUserToUser(): User {
        return User(
            id = this.id.orEmpty(),
            username = this.username.orEmpty(),
            role = this.role.orEmpty(),
            imageUrl = this.imageUrl.orEmpty(),
            fullName = this.fullName.orEmpty(),
            city = this.city.orEmpty(),
            simpleAddress = this.simpleAddress.orEmpty()
        )
    }
}