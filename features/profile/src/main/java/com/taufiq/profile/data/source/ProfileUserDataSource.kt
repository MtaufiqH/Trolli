package com.taufiq.profile.data.source

import com.taufiq.profile.data.entity.User
import com.taufiq.profile.data.remote.WebService
import com.taufiq.profile.data.ProfileMapper.responseUserToUser
import com.taufiq.core.utils.mapObservable
import io.reactivex.Observable

class ProfileUserDataSource(private val webService: WebService) {

    fun getUser(): Observable<User> {
        return webService.getUser().mapObservable {
            it.responseUserToUser()
        }
    }
}