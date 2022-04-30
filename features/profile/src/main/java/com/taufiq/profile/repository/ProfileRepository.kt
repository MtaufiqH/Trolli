package com.taufiq.profile.repository

import com.taufiq.profile.data.entity.User
import com.taufiq.core.event.StateEventManager
import java.io.Closeable

// api (interface) sebagai object
// impl sebagai implementasi dari api
interface ProfileRepository : Closeable {
    val userStateEventManager: StateEventManager<User>

    fun getUser()
}