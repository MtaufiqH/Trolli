package com.taufiq.trolli.splash

import androidx.lifecycle.ViewModel
import com.taufiq.core.event.StateEventManager
import com.taufiq.profile.data.entity.User
import com.taufiq.profile.repository.ProfileRepository
import okhttp3.internal.closeQuietly

class SplashViewModel(private val profileRepository: ProfileRepository) : ViewModel() {

    val userManager: StateEventManager<User> = profileRepository.userStateEventManager

    fun getUser(){
        profileRepository.getUser()
    }

    override fun onCleared() {
        super.onCleared()
        profileRepository.closeQuietly()
        userManager.closeQuietly()
    }
}