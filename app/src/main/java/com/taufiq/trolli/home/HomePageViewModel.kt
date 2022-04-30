package com.taufiq.trolli.home

import androidx.lifecycle.ViewModel
import com.taufiq.core.event.StateEventManager
import com.taufiq.profile.data.entity.User
import com.taufiq.profile.repository.ProfileRepository
import okhttp3.internal.closeQuietly

class HomePageViewModel(private val repository: ProfileRepository): ViewModel() {

    val userManager: StateEventManager<User> = repository.userStateEventManager

    fun getUser(){
        repository.getUser()
    }

    override fun onCleared() {
        super.onCleared()
        repository.closeQuietly()
        userManager.closeQuietly()
    }
}