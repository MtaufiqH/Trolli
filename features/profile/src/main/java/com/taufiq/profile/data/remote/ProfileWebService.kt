package com.taufiq.profile.data.remote

import com.taufiq.core.utils.TrolliResponse
import com.taufiq.core.utils.UtilConstant
import com.taufiq.profile.data.remote.response.UserResponse
import retrofit2.http.GET
import retrofit2.http.Header

interface ProfileWebService {

    @GET(EndPoint.User.GET_USER)
    fun getUser(
        @Header("authorization") auth: String = UtilConstant.TOKEN_EXAMPLE
    ): TrolliResponse<UserResponse>

}

object EndPoint {

    object User {
        const val GET_USER = "user"
    }
}